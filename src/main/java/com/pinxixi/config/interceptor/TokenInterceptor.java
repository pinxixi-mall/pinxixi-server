package com.pinxixi.config.interceptor;

import com.pinxixi.common.HttpStatusEnum;
import com.pinxixi.config.JWTConfig;
import com.pinxixi.config.PinxixiException;
import com.pinxixi.utils.RedisUtils;
import com.pinxixi.utils.StringUtils;
import com.pinxixi.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(JWTConfig.tokenHeader);
        String path = request.getRequestURI();

        if (StringUtils.hasLength(token) && token.startsWith(JWTConfig.tokenPrefix)) {
            token = TokenUtils.splitTokenPrefix(token);
            String tokenCacheKey = TokenUtils.getTokenCacheKey(token, path.indexOf("/admin") > -1 ? "admin" : "client");
            Object tokenCache = redisUtils.get(tokenCacheKey);
            if (tokenCache == null) {
                //登录已失效
                throw new PinxixiException(HttpStatusEnum.INVALID_AUTH.getCode(), HttpStatusEnum.INVALID_AUTH.getMsg());
            }
            TokenUtils.verifyToken(token);
        } else {
            throw new PinxixiException(HttpStatusEnum.UNAUTHORIZED.getCode(), HttpStatusEnum.UNAUTHORIZED.getMsg());
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}

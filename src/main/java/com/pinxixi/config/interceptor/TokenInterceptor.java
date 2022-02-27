package com.pinxixi.config.interceptor;

import com.pinxixi.common.HttpStatusEnum;
import com.pinxixi.config.JWTConfig;
import com.pinxixi.config.PinxixiException;
import com.pinxixi.utils.StringUtils;
import com.pinxixi.utils.TokenUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(JWTConfig.tokenHeader);

        if (!StringUtils.hasLength(token)) {
            throw new PinxixiException(HttpStatusEnum.UNAUTHORIZED.getCode(), HttpStatusEnum.UNAUTHORIZED.getMsg());
        }

        TokenUtils.verifyToken(token);

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}

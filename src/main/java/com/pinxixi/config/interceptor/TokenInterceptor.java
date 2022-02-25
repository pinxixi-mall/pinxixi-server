package com.pinxixi.config.interceptor;

import com.pinxixi.common.HttpStatusEnum;
import com.pinxixi.config.PinxixiException;
import com.pinxixi.utils.StringUtils;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Value("${pinxixi.jwt.exclude}")
    private String[] noTokenUrls;

    @Value("${pinxixi.jwt.header_auth}")
    private String headerAuth;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(headerAuth);
        //System.out.println(request.getRequestURI());
        //System.out.println(response.getStatus());
        if (!StringUtils.hasLength(token)) {
            throw new PinxixiException(HttpStatusEnum.UNAUTHORIZED.getCode(), HttpStatusEnum.UNAUTHORIZED.getMsg());
        }


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}

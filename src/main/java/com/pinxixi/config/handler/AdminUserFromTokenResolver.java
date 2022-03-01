package com.pinxixi.config.handler;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pinxixi.config.JWTConfig;
import com.pinxixi.config.annotation.AdminUserFromToken;
import com.pinxixi.dao.AdminUserMapper;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AdminUserFromTokenResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //有AdminUserFromToken注解才解析
        return parameter.hasParameterAnnotation(AdminUserFromToken.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = JWTUtils.splitTokenPrefix(webRequest.getHeader(JWTConfig.tokenHeader));
        DecodedJWT jwt = JWTUtils.verifyToken(token);
        String  userName = String.valueOf(jwt.getClaim("userName"));
        System.out.println(jwt.getClaim("userName"));
        AdminUser adminUser = adminUserMapper.selectUserByName(userName);
        return adminUser;
    }
}

package com.pinxixi.config.handler;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.pinxixi.config.JWTConfig;
import com.pinxixi.config.annotation.AdminUserArgument;
import com.pinxixi.dao.AdminUserMapper;
import com.pinxixi.entity.AdminUser;
import com.pinxixi.utils.JWTUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

/**
 * 注解@AdminUserArgument处理
 */
@Component
public class AdminUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //有AdminUserArgument注解才解析
        return parameter.hasParameterAnnotation(AdminUserArgument.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = JWTUtils.splitTokenPrefix(webRequest.getHeader(JWTConfig.tokenHeader));
        DecodedJWT jwt = JWTUtils.verifyToken(token);
        String userName = jwt.getClaim("userName").asString();
        AdminUser adminUser = adminUserMapper.selectUserByName(userName);
        return adminUser;
    }
}

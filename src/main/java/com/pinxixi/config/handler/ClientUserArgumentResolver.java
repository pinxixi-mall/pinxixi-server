package com.pinxixi.config.handler;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.pinxixi.config.JWTConfig;
import com.pinxixi.config.annotation.ClientUserArgument;
import com.pinxixi.dao.ClientUserMapper;
import com.pinxixi.entity.ClientUser;
import com.pinxixi.utils.JWTUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

/**
 * 注解@ClientUserArgument处理
 */
@Component
public class ClientUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Resource
    private ClientUserMapper userMapper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //有ClientUserArgument注解才解析
        return parameter.hasParameterAnnotation(ClientUserArgument.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String token = JWTUtils.splitTokenPrefix(webRequest.getHeader(JWTConfig.tokenHeader));
        DecodedJWT jwt = JWTUtils.verifyToken(token);
        String userName = jwt.getClaim("userName").asString();
        ClientUser clientUser = userMapper.selectUserByName(userName);
        return clientUser;
    }
}

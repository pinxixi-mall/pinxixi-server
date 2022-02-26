package com.pinxixi.config;

/**
 * 项目配置
 */
public class PinxixiMallConfig {

    //token过期时间: 30分钟
    public static final long TOKEN_EXPIRED_TIME = 30 * 60 * 1000;

    //token秘钥
    public static final String TOKEN_SECRET = "pinxixi2022666";

    //token请求头
    public static final String AUTH_HEADER = "Authorization";

    //不需要token的url
    public static final String[] JWT_EXCLUDE_URL = { "/admin/login", "/client/register", "/client/login", "/error" };
}

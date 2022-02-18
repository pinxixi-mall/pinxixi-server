package com.pinxixi.common;

/**
 * http状态码
 */
public class HttpStatus {

    /**
     * 成功
     */
    public static final int SUCCESS = 200;

    /**
     * 请求成功，没有返回数据
     */
    public static final int NO_CONTENT = 204;

    /**
     * 客户端请求的语法错误
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 请求未授权
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 授权过期
     */
    public static final int FORBIDDEN = 403;

    /**
     * 资源未找到
     */
    public static final int NOT_FOUND = 404;

    /**
     * 系统错误
     */
    public static final int ERROR = 500;

}

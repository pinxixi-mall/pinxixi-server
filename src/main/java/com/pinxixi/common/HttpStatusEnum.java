package com.pinxixi.common;

/**
 * 响应状态码枚举
 */
public enum HttpStatusEnum {

    SUCCESS(200, "操作成功"),

    NO_CONTENT(204, "没有数据"),

    BAD_REQUEST(400, "请求语法错误"),

    UNAUTHORIZED(401, "请求未授权"),

    FORBIDDEN(403, "授权过期"),

    NOT_FOUND(404, "资源未找到"),

    ERROR(500, "系统错误"),

    FAIL(-1, "请求失败");


    /**
     * 状态码
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    HttpStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

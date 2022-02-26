package com.pinxixi.common;

/**
 * service返回结果枚举
 */
public enum ServiceResultEnum {

    SUCCESS("success"),

    ERROR("ERROR"),

    LOGIN_SUCCESS("登录成功"),

    LOGIN_FAIL("用户名或密码错误"),

    USER_NOT_FOUND("没找到用户");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

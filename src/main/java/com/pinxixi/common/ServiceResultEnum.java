package com.pinxixi.common;

/**
 * service返回结果枚举
 */
public enum ServiceResultEnum {

    SUCCESS("success"),

    ERROR("ERROR"),

    LOGIN_SUCCESS("登录成功"),

    LOGIN_FAIL("用户名或密码错误"),

    LOGOUT_SUCCESS("退出登录成功"),

    LOGOUT_FAIL("退出登录失败"),

    USER_NOT_FOUND("没找到用户"),

    PAGE_PARAM_ERROR("分页参数有误"),

    GOODS_EXISTS("商品已存在");

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

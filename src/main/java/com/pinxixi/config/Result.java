package com.pinxixi.config;

import com.pinxixi.common.HttpStatusEnum;

import java.util.HashMap;

/**
 * 返回结果
 */
public class Result extends HashMap<String, Object> {

    public Result() {}

    public Result(int code, String msg, Object data) {
        super.put("code", code);
        super.put("msg", msg);
        super.put("data", data);
    }

    /***************** 成功 ******************/

    /**
     * 请求成功
     * @return 默认成功提示
     */
    public static Result success() {
        return Result.success(HttpStatusEnum.SUCCESS.getMsg());
    }

    /**
     * 请求成功
     * @param msg 自定义消息
     * @return 自定义消息
     */
    public static Result success(String msg) {
        return Result.success(msg, null);
    }

    /**
     * 请求成功
     * @param data 返回数据
     * @return 默认消息+数据
     */
    public static Result success(Object data) {
        return Result.success(HttpStatusEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 请求成功
     * @param msg 成功提示
     * @param data 返回数据
     * @return 自定义消息+数据
     */
    public static Result success(String msg, Object data) {
        return Result.success(HttpStatusEnum.SUCCESS.getCode(), msg, data);
    }

    /**
     * 请求成功
     * @param code 自定义成功状态码
     * @param msg 自定义消息
     * @param data 返回数据
     * @return 自定义状态码+自定义消息+返回数据
     */
    public static Result success(int code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    /***************** 失败 ******************/

    /**
     * 请求失败
     * @return 默认失败提示
     */
    public static Result fail() {
        return Result.fail(HttpStatusEnum.FAIL.getMsg());
    }

    /**
     * 请求失败
     * @param msg 失败提示
     * @return
     */
    public static Result fail(String msg) {
        return Result.fail(HttpStatusEnum.FAIL.getCode(), msg, null);
    }

    /**
     * 请求失败
     * @param code 失败状态码
     * @param msg 失败提示
     * @return
     */
    public static Result fail(int code, String msg) {
        return Result.fail(code, msg, null);
    }

    /**
     * 请求失败
     * @param code 失败状态码
     * @param msg 失败提示
     * @param data 失败数据
     * @return
     */
    public static Result fail(int code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    /**
     * 系统错误
     * @return
     */
    public static Result error() {
        return Result.error(HttpStatusEnum.ERROR.getCode(), HttpStatusEnum.ERROR.getMsg());
    }

    /**
     * 系统错误
     * @param code
     * @param msg
     * @return
     */
    public static Result error(int code, String msg) {
        return new Result(code, msg, null);
    }
}

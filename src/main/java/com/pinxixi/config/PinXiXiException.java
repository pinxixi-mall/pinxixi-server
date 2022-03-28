package com.pinxixi.config;

import com.pinxixi.common.HttpStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义异常
 */
@Data
@AllArgsConstructor
public class PinXiXiException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private int errorCode;

    private String errorMsg;

    public static void error(int errorCode, String errorMsg) {
        throw new PinXiXiException(errorCode, errorMsg);
    }

    public static void fail() {
        throw new PinXiXiException(HttpStatusEnum.FAIL.getCode(), HttpStatusEnum.FAIL.getMsg());
    }

}

package com.pinxixi.config;

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

}

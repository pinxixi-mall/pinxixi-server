package com.pinxixi.config.handler;

import com.pinxixi.common.HttpStatusEnum;
import com.pinxixi.common.Result;
import com.pinxixi.config.PinXiXiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Objects;

@RestControllerAdvice
public class PinXiXiExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(PinXiXiExceptionHandler.class);

    //自定义异常
    @ExceptionHandler(PinXiXiException.class)
    public Result PinxixiExceptionHandler(PinXiXiException e) {
        return Result.error(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(BindException.class)
    public Result exceptionHandler(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        return Result.error(501, Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    //参数校验
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result exceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return Result.error(501, Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    //404
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result exceptionHandler(NoHandlerFoundException e) {
        e.printStackTrace();
        return Result.error(HttpStatusEnum.NOT_FOUND.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        LOGGER.error("未知异常");
        return Result.error(500, "未知异常");
    }
}

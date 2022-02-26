package com.pinxixi.config;

import com.pinxixi.common.HttpStatusEnum;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
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
public class PinxixiExceptionHandler {

    //自定义异常
    @ExceptionHandler(PinxixiException.class)
    public Result PinxixiExceptionHandler(PinxixiException e) {
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
        System.out.println(e.getMessage());
        return Result.error(HttpStatusEnum.NOT_FOUND.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpRequest httpRequest, HttpResponse httpResponse, Exception e) {
        System.out.println(httpResponse.getStatusCode());
        e.printStackTrace();
        return Result.error(500, e.getMessage());
    }
}

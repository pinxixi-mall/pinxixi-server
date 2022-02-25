package com.pinxixi.config;

import com.pinxixi.common.HttpStatusEnum;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Objects;

@RestControllerAdvice
public class PinxixiExceptionHandler {

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(PinxixiException.class)
    public Result PinxixiExceptionHandler(PinxixiException e) {
        return Result.error(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(BindException.class)
    public Result exceptionHandler(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        return Result.error(501, Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result exceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return Result.error(501, Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    //TODO 以下拦截不生效
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result exceptionHandler(HttpRequest httpRequest, NoHandlerFoundException e) {
        return Result.error(HttpStatusEnum.NOT_FOUND.getCode(), HttpStatusEnum.NOT_FOUND.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(HttpRequest httpRequest, HttpResponse httpResponse, Exception e) {
        System.out.println(httpResponse.getStatusCode());
        e.printStackTrace();
        return Result.error(500, e.getMessage());
    }
}

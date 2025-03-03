package com.awc20.spzx.common.exception;

import com.awc20.spzx.model.vo.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        System.out.println("捕获到异常，打印异常信息：");
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }
}

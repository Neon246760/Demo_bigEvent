package com.neon.demo_big_event.common;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice 注解用于全局异常处理
// 1. 是@ControllerAdvice和@ResponseBody的组合注解
// 2. 用于统一处理Spring MVC应用中的异常
// 3. 可以对所有Controller中抛出的异常进行集中处理
// 4. 返回的数据会自动转换为JSON格式
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public <T> Response<T> handleException(Exception e) {
        e.printStackTrace();
        return Response.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作失败");
    }
}

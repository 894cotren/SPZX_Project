package com.awc20.spzx.common.anno;

import com.awc20.spzx.common.exception.GlobalExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(GlobalExceptionHandler.class)
public @interface EnbaleGlobalExceptionHandler {
}

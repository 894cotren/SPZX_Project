package com.awc20.spzx.common.log.annotation;

import com.awc20.spzx.common.log.aspect.MyLogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyLogAspect.class)
public @interface EnableMyLogAspect {
}

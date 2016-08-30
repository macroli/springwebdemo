package com.example.utils;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Macro_Li on 2016/3/19.
 */
@EnableAspectJAutoProxy
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAop {
    String name() default "test";
}

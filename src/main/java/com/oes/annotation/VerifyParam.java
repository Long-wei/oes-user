package com.oes.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author LongWei
 * @version 1.0
 * @date 2025/3/28 21:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
public @interface VerifyParam {

    int min() default -1;
    int max() default -1;

    boolean required() default false;

    boolean checkLogin() default true;

}

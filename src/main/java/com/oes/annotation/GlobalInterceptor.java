package com.oes.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @author LongWei
 * @date 2025/5/21 21:45
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface GlobalInterceptor {

    boolean checkParams() default false;

    boolean checkLogin() default true;

}


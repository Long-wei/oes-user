package com.oes.entity.constant;

/**
 * @author LongWei
 * @date 2025/5/22 11:06
 */
public class Constant {

    // redis key of user login message
    public static final String REDIS_USER_LOGIN = "user:login";

    // redis expire time of user login
    public static final Integer REDIS_EXPIRE_USER_LOGIN = 60 * 60 * 24;

    // jwt expire time of user login
    public static final Integer JWT_EXPIRE_USER_LOGIN = 60 * 24;

    // login request head cookie name
    public static final String COOKIE_USER_LOGIN = "USER_LOGIN";
}

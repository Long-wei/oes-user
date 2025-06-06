package com.oes.service;

import com.oes.entity.po.UserToken;

import javax.servlet.http.Cookie;

/**
 * @author LongWei
 * @date 2025/6/4 10:56
 */
public interface UserTokenService {

    /**
     * 保存用户登录生成的token
     * @param userToken
     */
    void saveUserToken(UserToken userToken);

    /**
     * 通过JWTToken生成登录cookie
     * @param value
     * @return
     */
    Cookie generateCookie(String value, String name, String path, Integer age);

    /**
     *  通过userId生成Token
     * @param userId
     * @return
     */
    String generateJWTToken(String userId);

    /**
     * 更新
     * @param userToken
     */
    void updateUserToken(UserToken userToken);

}

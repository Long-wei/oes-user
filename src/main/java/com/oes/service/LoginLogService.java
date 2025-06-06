package com.oes.service;

/**
 * @author LongWei
 * @date 2025/5/27 0:27
 */
public interface LoginLogService {

    /**
     * 通过用户Id和用户名保存用户登录信息，自动生成其他信息
     *
     * @param userId
     * @param username
     */
    public void saveByUserIdAndUsername(String userId, String username);
}
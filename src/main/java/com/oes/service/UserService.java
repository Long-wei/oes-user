package com.oes.service;

import com.oes.entity.dto.LoginDto;
import com.oes.entity.po.User;

/**
 * @author LongWei
 * @date 2025/5/22 10:27
 */
public interface UserService {

    /**
     * 用户登录
     * @param username
     * @param password
     */
    public LoginDto login(String username, String password);

    /**
     * 通过id查询某个用户信息
     * @param id
     * @return
     */
    public User findUserById(String id);


    /**
     * 更新
     * @param user
     */
    public void updateUser(User user);
}

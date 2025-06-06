package com.oes.mapper;

import com.oes.entity.dto.LoginDto;
import com.oes.entity.po.User;

/**
 * @author LongWei
 * @date 2025/5/22 10:28
 */
public interface UserMapper {

    /**
     * 通过用户名查询用户名和密码
     * @param username
     * @return
     */
    public LoginDto selectLoginDtoByUsername(String username);

    /**
     * 通过id查询某个用户
     * @param id
     * @return
     */
    public User selectUserById(String id);

    /**
     * 更新
     * @param user
     */
    public void updateUser(User user);

}

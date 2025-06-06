package com.oes.service.impl;

import com.oes.component.RedisComponent;
import com.oes.entity.dto.LoginDto;
import com.oes.entity.enums.UserStatusEnum;
import com.oes.entity.po.User;
import com.oes.exception.BusinessException;
import com.oes.mapper.UserMapper;
import com.oes.service.LoginLogService;
import com.oes.service.UserService;
import com.oes.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author LongWei
 * @date 2025/5/22 10:27
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private RedisComponent redisComponent;

    @Resource
    private LoginLogService loginLogService;

    @Resource
    private UserMapper userMapper;


    @Override
    public LoginDto login(String username, String password) {
        LoginDto loginDto = userMapper.selectLoginDtoByUsername(username);
        if (loginDto == null) {
            throw new BusinessException("用户名或密码错误");
        }
        if (!UserStatusEnum.ENABLE.getStatus().equals(loginDto.getStatus())) {
            throw new BusinessException("用户已禁用");
        }
        if (!password.equals(loginDto.getPassword())) {
            throw new BusinessException("用户名或密码错误");
        }
        // loginLog存储登录信息
        loginLogService.saveByUserIdAndUsername(loginDto.getId(), loginDto.getUsername());
        // 跟新最后登录时间
        User user = new User();
        user.setId(loginDto.getId());
        user.setLastLoginTime(DateUtils.getCurrentDateTime());
        user.setLastLoginIp(null);  // TODO 最后登录ip地址
        userMapper.updateUser(user);
        return loginDto;
    }

    @Override
    public User findUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}

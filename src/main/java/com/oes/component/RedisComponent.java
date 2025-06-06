package com.oes.component;

import com.oes.entity.constant.Constant;
import com.oes.entity.dto.LoginDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author LongWei
 * @date 2025/5/22 11:04
 */
@Component("redisComponent")
public class RedisComponent {

    @Resource
    private RedisUtils redisUtils;

    public void setUserLogin(String token, LoginDto loginDto) {
        redisUtils.setEx(Constant.REDIS_USER_LOGIN + token, loginDto, Constant.REDIS_EXPIRE_USER_LOGIN);
    }
    public LoginDto getUserLogin(String token) {
        try {
            return (LoginDto) redisUtils.get(Constant.REDIS_USER_LOGIN + token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void removeUserLogin(String token) {
        redisUtils.delete(Constant.REDIS_USER_LOGIN + token);
    }

}

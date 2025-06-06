package com.oes.component;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.oes.entity.constant.Constant;
import com.oes.entity.dto.LoginDto;
import com.oes.utils.JwtUtils;
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
        DecodedJWT decodedJWT = JwtUtils.parseToken(token);
        String userId = decodedJWT.getClaim("id").toString();
        redisUtils.setEx(Constant.REDIS_USER_LOGIN + userId, loginDto, Constant.REDIS_EXPIRE_USER_LOGIN);
    }
    public LoginDto getUserLogin(String token) {
        try {
            DecodedJWT decodedJWT = JwtUtils.parseToken(token);
            String userId = decodedJWT.getClaim("id").toString();
            return (LoginDto) redisUtils.get(Constant.REDIS_USER_LOGIN + userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void removeUserLogin(String token) {
        DecodedJWT decodedJWT = JwtUtils.parseToken(token);
        String userId = decodedJWT.getClaim("id").toString();
        redisUtils.delete(Constant.REDIS_USER_LOGIN + userId);
    }

}

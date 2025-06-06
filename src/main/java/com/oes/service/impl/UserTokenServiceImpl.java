package com.oes.service.impl;

import com.oes.entity.constant.Constant;
import com.oes.entity.enums.TokenTypeEnum;
import com.oes.entity.po.UserToken;
import com.oes.mapper.UserTokenMapper;
import com.oes.service.UserTokenService;
import com.oes.utils.DateUtils;
import com.oes.utils.JwtUtils;
import com.oes.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.HashMap;

/**
 * @author LongWei
 * @date 2025/6/4 10:56
 */
@Transactional()
@Service
public class UserTokenServiceImpl implements UserTokenService {

    @Resource
    private UserTokenMapper userTokenMapper;

    @Override
    public void saveUserToken(UserToken userToken) {
        userTokenMapper.insertUserToken(userToken);
    }

    @Override
    public Cookie generateCookie(String value, String name, String path, Integer age) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setPath(path);
        cookie.setMaxAge(age);
        return cookie;
    }

    @Override
    public String generateJWTToken(String userId) {
        HashMap<String, String> claims = new HashMap<>();
        claims.put("id", userId);
        String token = JwtUtils.generateToken(claims, Constant.JWT_EXPIRE_USER_LOGIN);

        // 保存token
        UserToken userToken = new UserToken();
        userToken.setUserId(userId);
        userToken.setToken(token);
        userToken.setId(StringUtils.randomString36());
        userToken.setTokenType(TokenTypeEnum.ACCESS.getType());
        long millisecondsInDay = 24 * 60 * 60 * 1000;
        userToken.setExpireTime(new Date(DateUtils.getCurrentDateTime().getTime() + millisecondsInDay));
        userToken.setCreateTime(DateUtils.getCurrentDateTime());
        userToken.setUpdateTime(DateUtils.getCurrentDateTime());
        userTokenMapper.insertUserToken(userToken);
        return token;
    }

    @Override
    public void updateUserToken(UserToken userToken) {
        userTokenMapper.updateUserToken(userToken);
    }
}

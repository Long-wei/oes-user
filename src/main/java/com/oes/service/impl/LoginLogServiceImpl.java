package com.oes.service.impl;

import com.oes.entity.po.LoginLog;
import com.oes.mapper.LoginLogMapper;
import com.oes.service.LoginLogService;
import com.oes.utils.DateUtils;
import com.oes.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author LongWei
 * @date 2025/5/27 0:27
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public void saveByUserIdAndUsername(String userId, String username) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(username);
        loginLog.setUserId(userId);
        loginLog.setId(StringUtils.randomString36());
        loginLog.setLoginTime(new Date());
        loginLogMapper.insert(loginLog);
    }
}

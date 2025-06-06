package com.oes.mapper;

import com.oes.entity.po.LoginLog;
import org.apache.ibatis.annotations.Param;

/**
 * @author LongWei
 * @date 2025/5/27 0:50
 */
public interface LoginLogMapper {
    public void insert(@Param("loginLog")LoginLog loginLog);
}

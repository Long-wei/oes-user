package com.oes.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 登录日志
 * @author LongWei
 * @date 2025/5/20 16:03
 */
@Data
public class LoginLog {
    // 主键ID
    private String id;
    // 用户ID
    private String userId;
    // 用户名
    private String username;
    // IP地址
    private String ip;
    // 登录地点
    private String location;
    // 登录设备
    private String device;
    // 浏览器类型
    private String browser;
    // 操作系统
    private String os;
    // 登录状态(0-失败 1-成功)
    private Integer status;
    // 提示消息
    private String msg;
    // 登录时间
    @JsonFormat(pattern = "yyyy-HH-dd HH:mm:ss")
    private Date loginTime;
}

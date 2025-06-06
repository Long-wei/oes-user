package com.oes.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户档案表
 * @author LongWei
 * @date 2025/5/20 16:30
 */
@Data
public class UserProfile {
    private String id;
    private String userId;
    private String idCard;
    private String education;
    private String school;
    private String major;
    private String address;
    // 个人简介
    private String introduction;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}

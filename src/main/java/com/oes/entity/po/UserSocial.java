package com.oes.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户社交账号
 * @author LongWei
 * @date 2025/5/20 16:35
 */
@Data
public class UserSocial {
    private String id;
    private String userId;
    private String socialType;
    private String socialId;
    private String socialName;
    private String socialAvatar;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}

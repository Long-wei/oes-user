package com.oes.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户令牌表
 * @author LongWei
 * @date 2025/5/20 20:26
 */
@Data
public class UserToken {
    private String id;
    private String userId;
    private String token;
    private Integer tokenType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}

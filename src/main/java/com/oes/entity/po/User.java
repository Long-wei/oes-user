package com.oes.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户基础
 * @author LongWei
 * @date 2025/5/20 16:25
 */
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String phone;
    private String realName;
    private String avatar;
    private Integer gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date birthday;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date lastLoginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private String lastLoginIp;
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date updateTime;
}

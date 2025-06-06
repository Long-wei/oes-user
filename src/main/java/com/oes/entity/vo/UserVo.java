package com.oes.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author LongWei
 * @date 2025/6/5 15:22
 */
@Data
public class UserVo {
    private String id;
    private String username;
    private String email;
    private String phone;
    private String avatar;
    private String realName;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTIme;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
}

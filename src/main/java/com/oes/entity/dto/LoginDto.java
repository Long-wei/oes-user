package com.oes.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录实体类
 * @author LongWei
 * @date 2025/5/22 10:32
 */
@Data
public class LoginDto implements Serializable {
    private String id;
    private String username;
    private String password;
    private Integer status;
    private String avatar;
    private String realName;
}

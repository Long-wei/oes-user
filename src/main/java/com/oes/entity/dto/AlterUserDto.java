package com.oes.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author LongWei
 * @date 2025/6/9 9:37
 */
@Data
public class AlterUserDto {

    private String id;
    private String username;
    private String email;
    private String phone;
    private String realName;
    private String avatar;
    private Integer gender;
    private Date birthday;

}

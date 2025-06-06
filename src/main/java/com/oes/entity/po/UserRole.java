package com.oes.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户角色关联
 * @author LongWei
 * @date 2025/5/20 16:34
 */
@Data
public class UserRole {
    private String id;
    private String userId;
    private String roleId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}

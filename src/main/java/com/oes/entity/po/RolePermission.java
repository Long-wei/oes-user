package com.oes.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 角色权限关联
 * @author LongWei
 * @date 2025/5/20 16:23
 */
@Data
public class RolePermission {
    private String id;
    //角色ID
    private String roleId;
    //权限ID
    private String permissionId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}

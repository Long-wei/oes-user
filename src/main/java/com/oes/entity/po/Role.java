package com.oes.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 角色
 * @author LongWei
 * @date 2025/5/20 16:19
 */
@Data
public class Role {
    //角色ID
    private String id;
    //角色名称
    private String name;
    //角色编码
    private String code;
    //角色描述
    private String description;
    //状态(0-禁用 1-正常)
    private Integer status;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}

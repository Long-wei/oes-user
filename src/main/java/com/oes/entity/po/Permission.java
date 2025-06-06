package com.oes.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 权限
 * @author LongWei
 * @date 2025/5/20 16:14
 */
@Data
public class Permission {
    //权限ID
    private String id;
    //权限名称
    private String name;
    //权限编码
    private String code;
    //权限类型(1-菜单 2-按钮 3-API)
    private Integer type;
    //父权限ID
    private String parentId;
    //路由路径
    private String path;
    //图标
    private String icon;
    //排序
    private Integer sort;
    //描述
    private String description;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}

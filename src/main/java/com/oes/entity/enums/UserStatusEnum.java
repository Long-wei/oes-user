package com.oes.entity.enums;

/**
 * @author LongWei
 * @date 2025/5/22 10:47
 */
public enum UserStatusEnum {
    ENABLE(1, "正常"),
    DISABLE(0, "禁用");

    private Integer status;
    private String desc;

    UserStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}

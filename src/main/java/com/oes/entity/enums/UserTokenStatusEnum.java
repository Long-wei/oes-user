package com.oes.entity.enums;

/**
 * @author LongWei
 * @date 2025/6/4 15:39
 */
public enum UserTokenStatusEnum {
    ENABLE(0, "有效"),
    DISABLE(1, "失效");

    private Integer status;
    private String desc;

    UserTokenStatusEnum(Integer status, String desc) {
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

package com.oes.entity.enums;

/**
 * @author LongWei
 * @date 2025/5/27 0:39
 */
public enum LoginStatusEnum {
    SUCCESS(1, "成功"),
    FAIL(0, "失败");

    private Integer status;
    private String desc;

    LoginStatusEnum(Integer status, String desc) {
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

package com.oes.entity.enums;

/**
 * @author LongWei
 * @date 2025/6/4 11:48
 */
public enum TokenTypeEnum {
    ACCESS(0, "访问"),
    REFRESH(1, "刷新");

    private Integer type;
    private String desc;

    TokenTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}

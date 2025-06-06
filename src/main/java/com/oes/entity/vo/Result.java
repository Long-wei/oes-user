package com.oes.entity.vo;

import lombok.Data;

/**
 * @author LongWei
 * @date 2025/5/21 11:29
 */
@Data
public class Result<T> {
    private String status;
    private Integer code;
    private String info;
    private T data;
}

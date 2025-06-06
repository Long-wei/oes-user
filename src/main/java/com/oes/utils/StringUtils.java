package com.oes.utils;

import java.util.UUID;

/**
 * @author LongWei
 * @date 2025/5/27 0:32
 */
public class StringUtils {

    /**
     * 雪花算法生成36为字符串
     * @return
     */
    public static String randomString36() {
        return UUID.randomUUID().toString();
    }
}

package com.oes.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LongWei
 * @date 2025/5/27 0:43
 */
public class DateUtils {
    /**
     * 生成当前日期时间并返回Date对象
     * @return java.util.Date 当前日期时间对象
     */
    public static Date getCurrentDateTime() {
        return new Date(); // 直接返回当前时间的Date对象
    }

    /**
     * 将字符串日期转换为Date对象
     * @param dateStr 日期字符串(yyyy-MM-dd HH:mm:ss格式)
     * @return java.util.Date 转换后的Date对象
     * @throws ParseException 如果格式不匹配会抛出异常
     */
    public static Date parseToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(dateStr);
    }

    /**
     * 将Date对象格式化为字符串
     * @param date 要格式化的Date对象
     * @return 格式化后的字符串(yyyy-MM-dd HH:mm:ss格式)
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}

package com.oes.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author LongWei
 * @version 1.0
 * @date 2025/3/28 11:10
 */
@Component("redisUtils")
public class RedisUtils<V> {

    @Resource
    private RedisTemplate<String, V> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    public V get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, V value) {
        try{
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("设置redisKey:{}, value:{}失败", key, value);
            return false;
        }
    }

    public boolean setEx(String key, V value, Integer time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else  {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("设置redisKey:{}, value:{}失败", key, value);
            return false;
        }
    }

    public boolean delete(String key) {
        try {
            if (key != null) {
                redisTemplate.delete(key);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除redisKey:{}失败", key);
            return false;
        }
    }
}

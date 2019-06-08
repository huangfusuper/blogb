package com.blog.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author 皇甫
 */
@Configuration
public class RedisUtil {
    @Value("${redis.cachec.clear.TimeUnit}")
    private String timeUnit = "DAYS";
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 设置
     * @param key
     * @return
     */
    public void setObjectString(Object key,Object value,Long time){
        TimeUnit timeU = null;
        if("DAYS".equals(timeUnit)){
            timeU = TimeUnit.DAYS;
        }else if("MINUTES".equals(timeUnit)){
            timeU = TimeUnit.MINUTES;
        }else if("MILLISECONDS".equals(timeUnit)){
            timeU = TimeUnit.MILLISECONDS;
        }
        redisTemplate.opsForValue().set(key,value,time, timeU);
    }

    /**
     * 获取
     * @param key
     * @return
     */
    public Object getObjectString(Object key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public Boolean keyDoesItExist(Object key){
        Boolean aBoolean = redisTemplate.hasKey(key);
        return aBoolean;
    }
}

package com.tyk.config;

import org.springframework.data.redis.core.RedisTemplate;

public class RedisCacheTransfer {
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
    }
}

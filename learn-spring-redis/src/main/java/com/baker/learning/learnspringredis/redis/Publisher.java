package com.baker.learning.learnspringredis.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @description
 * @date 2020/3/26 9:33
 */
@Service
@Slf4j
public class Publisher {

    @Autowired
    private RedisTemplate redisTemplate;

    public void publish(Object msg) {
        redisTemplate.opsForValue().set("a", "123");
        log.info((String) redisTemplate.opsForValue().get("a"));
        redisTemplate.convertAndSend("demo-channel", msg);
    }
}

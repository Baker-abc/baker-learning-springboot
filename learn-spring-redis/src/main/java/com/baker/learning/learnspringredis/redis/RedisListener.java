package com.baker.learning.learnspringredis.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;

/**
 * @description
 * @date 2020/3/26 9:22
 */
@Component
@Slf4j
public class RedisListener implements MessageListener {

    @Autowired
    RedisLockRegistry redisLockRegistry;

    /**
     * 注意 unlock要在确定得到锁之后调用。
     *
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        Lock lock = redisLockRegistry.obtain("lock");
        try {
            if (!lock.tryLock()) {
                log.info("获取锁失败");
                return;
            }
            try {
                log.info("从消息通道={}监听到消息", new String(pattern));
                log.info("从消息通道={}监听到消息", new String(message.getChannel()));
                log.info("元消息={}", new String(message.getBody()));

                // 新建一个用于反序列化的对象，注意这里的对象要和前面配置的一样

                // 因为我前面设置的默认序列化方式为GenericJackson2JsonRedisSerializer

                // 所以这里的实现方式为GenericJackson2JsonRedisSerializer

                RedisSerializer serializer = new GenericJackson2JsonRedisSerializer();

                log.info("反序列化后的消息={}", (serializer.deserialize(message.getBody()).toString()));
                log.info("反序列化后的消息={}", ((GenericJackson2JsonRedisSerializer) serializer).deserialize(message.getBody(), UserInfo.class));

            } finally {
                lock.unlock();
            }
        } catch (Throwable throwable) {
            log.error("listener error:", throwable);
        }


    }
}

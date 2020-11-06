package com.lmwis.interview.redis.compoment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description: 分布式锁接口redis实现
 * @Author: lmwis
 * @Date 2020-11-06 16:45
 * @Version 1.0
 */
@Component
public class RedisLock implements DistributedLockOperation{

    @Autowired
    private static RedisTemplate redisTemplate;

    private String lockKey; // 锁的键值
    private int expreisedTime;

    @Override
    public boolean acquire() {
        return false;
    }

    @Override
    public void release() {

    }

    public void setLockKey(String lockKey) {
        this.lockKey = lockKey;
    }

    public String getLockKey() {
        return lockKey;
    }
}

package com.lmwis.interview.redis.compoment;

/**
 * @Description: 分布式锁操作接口
 * @Author: lmwis
 * @Date 2020-11-06 16:46
 * @Version 1.0
 */
public interface DistributedLockOperation {

    /**
     * 获取锁
     * @return
     */
    boolean acquire();

    /**
     * 释放锁
     */
    void release();
}

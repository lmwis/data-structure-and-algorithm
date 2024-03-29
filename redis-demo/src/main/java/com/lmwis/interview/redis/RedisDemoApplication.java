package com.lmwis.interview.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-11-06 16:29
 * @Version 1.0
 */
@SpringBootApplication
public class RedisDemoApplication {

    @Autowired
    RedisTemplate redisTemplate;

    public static void main(String[] args) {

        SpringApplication.run(RedisDemoApplication.class,args);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure()
        objectMapper.setConfig(new BeanSerializer());
    }


}

package com.cxn.example.redis.beans.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: xiangning
 * Date: 2019/2/28 22:45
 * To change this template use File | Settings | File Templates.
 * chenxiangning@reachauto.com
 */
@Configuration
@Data
public class MyRedisProperties {
    @Autowired
    private RedisProperties redisProperties;

    @Value("${spring.redis.database2}")
    private int database2;
    @Value("${spring.redis.database3}")
    private int database3;
}

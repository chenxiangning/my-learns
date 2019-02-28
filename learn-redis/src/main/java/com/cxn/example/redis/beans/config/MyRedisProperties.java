package com.cxn.example.redis.beans.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author cxn
 * chenxiangning@reachauto.com
 * 2019年2月28日 下午3:08
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

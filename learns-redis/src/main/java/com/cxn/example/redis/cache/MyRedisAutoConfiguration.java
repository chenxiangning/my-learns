package com.cxn.example.redis.cache;

import com.cxn.example.redis.beans.config.MyRedisProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created with IntelliJ IDEA.
 * User: xiangning
 * Date: 2019/2/28 22:48
 * To change this template use File | Settings | File Templates.
 * chenxiangning@reachauto.com
 */
@Configuration
@Slf4j
public class MyRedisAutoConfiguration {

    @Autowired
    private MyRedisProperties myRedisProperties;

    public RedisConnectionFactory createRedisConnectionFactory(MyRedisProperties myRedisProperties, int database) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(myRedisProperties.getRedisProperties().getPool().getMaxIdle());
        poolConfig.setMinIdle(myRedisProperties.getRedisProperties().getPool().getMinIdle());
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
        jedisConnectionFactory.setHostName(myRedisProperties.getRedisProperties().getHost());
        jedisConnectionFactory.setDatabase(database);
        jedisConnectionFactory.setPassword(myRedisProperties.getRedisProperties().getPassword());
        jedisConnectionFactory.setPort(myRedisProperties.getRedisProperties().getPort());
        jedisConnectionFactory.afterPropertiesSet();

        return jedisConnectionFactory;
    }

    @Bean(name = "strRedisTemplateDb2")
    public RedisTemplate<String, Object> strRedisTemplateDb2() {
        RedisTemplate strRedisTemplate = new RedisTemplate();
        strRedisTemplate.setConnectionFactory(createRedisConnectionFactory(myRedisProperties, myRedisProperties.getDatabase2()));
        strRedisTemplate.setKeySerializer(new StringRedisSerializer());
        strRedisTemplate.setValueSerializer(new StringRedisSerializer());
        strRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        strRedisTemplate.setHashValueSerializer(new StringRedisSerializer());
        log.info("######## strRedisTemplateDb2 index {} 初始化完毕", myRedisProperties.getDatabase2());
        return strRedisTemplate;
    }

    @Bean(name = "strRedisTemplateDb3")
    public RedisTemplate<String, Object> strRedisTemplateDb3() {
        RedisTemplate strRedisTemplate = new RedisTemplate();
        strRedisTemplate.setConnectionFactory(createRedisConnectionFactory(myRedisProperties, myRedisProperties.getDatabase3()));
        strRedisTemplate.setKeySerializer(new StringRedisSerializer());
        strRedisTemplate.setValueSerializer(new StringRedisSerializer());
        strRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        strRedisTemplate.setHashValueSerializer(new StringRedisSerializer());
        log.info("######## strRedisTemplateDb3 index {} 初始化完毕", myRedisProperties.getDatabase3());
        return strRedisTemplate;
    }

}

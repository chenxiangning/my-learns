package com.cxn.example.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: xiangning
 * Date: 2019/3/3 19:48
 * To change this template use File | Settings | File Templates.
 * chenxiangning@reachauto.com
 */
@Component("myRedisCacheStrKeyStrValImpl")
public class MyRedisCacheStrKeyStrValImpl implements MyRedisCache {

    @Autowired
    @Qualifier(value = "strRedisTemplateDb2")
    private RedisTemplate redisTemplate;


    @Override
    public void set(String key, String val, long timeout) {
        redisTemplate.opsForValue().set(key, val, timeout, TimeUnit.SECONDS);
    }

    @Override
    public void set(String key, String val) {
        redisTemplate.opsForValue().set(key, val);
    }

    @Override
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void expire(String key, long timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    @Override
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public boolean hashKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Set<String> keys(String patten) {
        return redisTemplate.keys(patten);
    }
}

package com.cxn.example.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xiangning
 * Date: 2019/3/3 20:30
 * To change this template use File | Settings | File Templates.
 * chenxiangning@reachauto.com
 */
@Component("myRedisHashCacheImpl")
public class MyRedisHashCacheImpl implements MyRedisHashCache {

    @Autowired
    @Qualifier(value = "strRedisTemplateDb2")
    private RedisTemplate redisTemplate;


    @Override
    public void set(Key key, Map map) {
        redisTemplate.opsForHash().putAll(key.getTrueKey(), map);
    }

    @Override
    public Map get(Key key) {
        return redisTemplate.opsForHash().entries(key.getTrueKey());
    }

    @Override
    public void setMapKeyAndVal(Key key, String hashKey, String hashVal) {
        redisTemplate.opsForHash().put(key.getTrueKey(), hashKey, hashVal);
    }

    @Override
    public String getMapValByKey(Key key, String hashKey) {
        return (String) redisTemplate.opsForHash().get(key.getTrueKey(), hashKey);
    }

}

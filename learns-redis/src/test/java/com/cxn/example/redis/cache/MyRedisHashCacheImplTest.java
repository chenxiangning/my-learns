package com.cxn.example.redis.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.Map;

public class MyRedisHashCacheImplTest extends AbsTest {

    @Autowired
    @Qualifier(value = "myRedisHashCacheImpl")
    private MyRedisHashCache myRedisHashCache;

    @Test
    public void set() {

        Map map = new HashMap();
        map.put("a", "b");
        map.put("aa", "b");
        map.put("aaa", "b");
        map.put("aaaa", "b");

        Key key = Key.build("map:a");
        myRedisHashCache.set(key, map);

        System.out.println(myRedisHashCache.get(key));

        myRedisHashCache.setMapKeyAndVal(key, "b", "第五个");

        System.out.println(myRedisHashCache.getMapValByKey(key, "b"));
        System.out.println(myRedisHashCache.getMapValByKey(key, "a"));
        System.out.println(myRedisHashCache.getMapValByKey(key, "cc"));

    }

    @Test
    public void set2(){
        Map map = new HashMap();
        map.put("a", "b");
        map.put("aa", "b");
        map.put("aaa", "b");
        map.put("aaaa", "b");
        myRedisHashCache.set(Key.build("map:a"), map);

    }
}

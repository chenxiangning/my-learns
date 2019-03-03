package com.cxn.example.redis.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyRedisCacheStrKeyStrValImplTest extends AbsTest {

    @Autowired
    @Qualifier(value = "myRedisCacheStrKeyStrValImpl")
    private MyRedisCache myRedisCache;

    @Test
    public void set() {

        myRedisCache.set(Key.build("val:key1").getTrueKey(), "sss");
        myRedisCache.set("key2", "123");
        myRedisCache.set("key3", "陈湘宁");
        myRedisCache.set("key4", "陈湘宁", 10);
    }

    @Test
    public void get() {
        System.out.println("#####1 ->> " + myRedisCache.get("key1"));
        System.out.println("#####2 ->> " + myRedisCache.get("key2"));
        System.out.println("#####3 ->> " + myRedisCache.get("key3"));
    }

    @Test
    public void mytest() {
        myRedisCache.set("key-test", "你好");
        System.out.println(myRedisCache.get("key-test"));

        System.out.println(String.format("hash key %s hash key2 %s",
                myRedisCache.hashKey("key-test"), myRedisCache.hashKey("key-test2")));

        System.out.println(myRedisCache.keys("key*"));

        myRedisCache.del("key-test");

        System.out.println(myRedisCache.hashKey("key-test"));

    }

    @Test
    public void expire() throws InterruptedException {


        myRedisCache.set("key1", "sss");
        myRedisCache.expire("key1", 10);

        for (int i = 0; i < 10; i++) {
            System.out.println(myRedisCache.getExpire("key1"));

            Thread.currentThread().sleep(1000L);
        }
    }

    @Test
    public void getExpire() {
    }

    @Test
    public void del() {
    }

    @Test
    public void hashKey() {

    }

    @Test
    public void keys() {

    }
}

package com.cxn.example.redis.cache;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: xiangning
 * Date: 2019/3/3 19:44
 * To change this template use File | Settings | File Templates.
 * chenxiangning@reachauto.com
 */
public interface MyRedisCache {
    /*1.设置value
    2.读取value
    3.设置key过期时间
    4.获取key过期时间
    5.删除缓存
    6.判断key是否存在
    7.获取key的列表*/

    void set(String key, String val, long timeout);

    void set(String key, String val);

    String get(String key);

    void expire(String key, long timeout);

    long getExpire(String key);

    void del(String key);

    boolean hashKey(String key);

    Set<String> keys(String patten);
}

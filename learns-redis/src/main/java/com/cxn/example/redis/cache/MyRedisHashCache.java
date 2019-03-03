package com.cxn.example.redis.cache;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xiangning
 * Date: 2019/3/3 19:44
 * To change this template use File | Settings | File Templates.
 * chenxiangning@reachauto.com
 */
public interface MyRedisHashCache {
    /*1.设置value
    2.读取value
    3.设置key过期时间
    4.获取key过期时间
    5.删除缓存
    6.判断key是否存在
    7.获取key的列表*/

    void set(Key key, Map map);

    Map get(Key key);

    void setMapKeyAndVal(Key key, String hashKey, String hashVal);

    String getMapValByKey(Key key, String hashKey);


}

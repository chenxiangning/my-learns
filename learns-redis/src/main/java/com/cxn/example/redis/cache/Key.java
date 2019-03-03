package com.cxn.example.redis.cache;

/**
 * Created with IntelliJ IDEA.
 * User: xiangning
 * Date: 2019/3/3 20:32
 * To change this template use File | Settings | File Templates.
 * chenxiangning@reachauto.com
 */
public class Key {

    private StringBuilder builder = new StringBuilder("cxn:redis_key:");

    public Key append(String key) {
        this.builder.append(key);
        return this;
    }

    public String getTrueKey() {
        return this.builder.toString();
    }

    public static Key build(String key) {
        Key key1 = new Key().append(key);
        return key1;
    }
}

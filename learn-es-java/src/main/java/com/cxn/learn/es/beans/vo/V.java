package com.cxn.learn.es.beans.vo;

import org.apache.http.HttpStatus;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: cxn
 * Date: 19-4-17 下午2:07
 * This is my work in reachauto code.
 * mail:chenxiangning1989@126.com
 * Description:
 */
public class V extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public V() {
        put("code", 0);
        put("description", "success");
        put("payload", null);
    }

    public static V error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static V error(String description) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, description);
    }

    public static V error(int code, String description) {
        V r = new V();
        r.put("code", code);
        r.put("description", description);
        return r;
    }

    public static V ok(String description) {
        V r = new V();
        r.put("description", description);
        return r;
    }

    public static V ok(Object payload) {
        V r = new V();
        r.put("payload", payload);
        return r;
    }

    public static V ok() {
        return new V();
    }

    @Override
    public V put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}


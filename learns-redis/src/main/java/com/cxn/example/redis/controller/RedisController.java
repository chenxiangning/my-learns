package com.cxn.example.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
@Slf4j
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    @Qualifier(value = "strRedisTemplateDb2")
    private RedisTemplate redisTemplateDb2;

    @Autowired
    @Qualifier("strRedisTemplateDb3")
    private RedisTemplate redisTemplateDb3;

    @RequestMapping(value = "/1",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String test1() {

        // 1 插入数据
        redisTemplate.opsForValue().set("a", "b");

        // 2 读取
        log.info("我读取的redis key 为a的值 = {}", redisTemplate.opsForValue().get("a"));

        return "ok";
    }

    @RequestMapping(value = "/2",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String test2(@RequestParam String key) {

        // 1 插入数据
        stringRedisTemplate.opsForValue().set("name", key);

        // 2 读取
        log.info("我读取的redis key 为c的值 = {}", stringRedisTemplate.opsForValue().get("name"));
        return "ok";
    }

    @RequestMapping(value = "/db2",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String test3(@RequestParam String key) {

        // 1 插入数据
        redisTemplateDb2.opsForValue().set("name", key);

        // 2 读取
        log.info("我读取的redis key 为c的值 = {}", redisTemplateDb2.opsForValue().get("name"));
        return "ok";
    }

    @RequestMapping(value = "/db3",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String test4(@RequestParam String key) {

        // 1 插入数据
        redisTemplateDb3.opsForValue().set("name", key);

        // 2 读取
        log.info("我读取的redis key 为c的值 = {}", redisTemplateDb3.opsForValue().get("name"));
        return "ok";
    }

}

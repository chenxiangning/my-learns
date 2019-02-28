package com.cxn.example.redis.controller;

import com.cxn.example.redis.beans.config.MyRedisProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
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
    private MyRedisProperties myRedisProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "1",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String redisDemo1(@RequestParam(value = "param1", required = false) String param1) {

        log.info("{} {}", redisTemplate, redisTemplate.opsForValue().get("key1"));

        redisTemplate.opsForValue().set("a", "12345");
        redisTemplate.opsForValue().set("b", "你好Redis");

        log.info("redis get ## a={}  b={}",
                redisTemplate.opsForValue().get("a"),
                redisTemplate.opsForValue().get("b"));

        log.info("redis 对比 ## {} {}",
                redisTemplate.opsForValue().get("a").equals("12345"),
                redisTemplate.opsForValue().get("b").equals("你好Redis"));

        return "hello:" + param1;
    }

    @RequestMapping(value = "2",
            method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String redisDemo2(@RequestParam(value = "param1", required = false) String param1) {

        log.info("{} {}", stringRedisTemplate, stringRedisTemplate.opsForValue().get("key1"));

        stringRedisTemplate.opsForValue().set("c", "12345");
        stringRedisTemplate.opsForValue().set("d", "你好Redis");
        stringRedisTemplate.opsForValue().set("h:d:o", "你好Redis");

        log.info("redis get ## c={}  d={}",
                stringRedisTemplate.opsForValue().get("c"),
                stringRedisTemplate.opsForValue().get("d"));

        log.info("redis 对比 ## {} {}",
                stringRedisTemplate.opsForValue().get("c").equals("12345"),
                stringRedisTemplate.opsForValue().get("d").equals("你好Redis"));
        return "hello:" + param1;
    }

}

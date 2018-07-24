package com.joyowo.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * author:chenby
 * Date:2018/6/12
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "article_click_cnt";

    @RequestMapping("/test")
    public Object test() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(KEY, "article_1", 88);

        Map<String, Object> map = new HashMap<>();
        map.put("article_2", 10);
        map.put("article_3", 5);
        map.put("arricle_4", 6);
        hashOperations.putAll(KEY, map);

        Object article_1 = hashOperations.get(KEY, "article_1");
        return article_1;
    }

}

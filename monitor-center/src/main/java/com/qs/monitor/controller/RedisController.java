package com.qs.monitor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 * @Version 1.0
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2020/11/5       create this file
 * </pre>
 */
@Controller
@RequestMapping(value = "/redis")
public class RedisController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisController.class.getName());

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping(value = "/setRedisInfo")
    @ResponseBody
    public String setOneRedisInfo(@RequestParam String redisKey, String redisInfo) {
        LOGGER.info("enter setOneRedisInfo");
        redisTemplate.opsForValue().set(redisKey, redisInfo);
        LOGGER.info("save finish");
        return (String) redisTemplate.opsForValue().get(redisKey);
    }


    @PostMapping(value = "/testStringRedisInfo")
    @ResponseBody
    public String testStringRedisInfo(@RequestParam String redisKey, String redisInfo) {
        LOGGER.info("enter testStringRedisInfo");
        stringRedisTemplate.opsForValue().set(redisKey, redisInfo);
        LOGGER.info("save finish");
        return stringRedisTemplate.opsForValue().get(redisKey);
    }

}

package com.soft1851.smart.campus.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/29
 * @Version 1.0
 */
@SpringBootTest
class RedisServiceTest {
    @Resource
    private RedisService redisService;

    @Test
    void set() {
        redisService.set("1","112221", (long)1);

    }

    @Test
    void getValue() {
        System.out.println(redisService.getValue("1", String.class));

    }
}
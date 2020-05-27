package com.soft1851.smart.campus.service;

import org.junit.jupiter.api.Test;
<<<<<<< src/test/java/com/soft1851/smart/campus/service/RedisServiceTest.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/26
 * @Version 1.0
 */
@SpringBootTest
class RedisServiceTest {

    @Resource
    private RedisService service;


    @Test
    public void save() {
        service.set("code", "132132132", (long) 10);
        if(service.existsKey("code")) {
            System.out.println(service.getValue("code", String.class));
        }
    }

    @Test
    public void test() {
        System.out.println(service.getValue("code", String.class));
    }
}
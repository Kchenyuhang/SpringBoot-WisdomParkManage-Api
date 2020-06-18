package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserAccountServiceTest {

    @Resource
    private UserAccountService userAccountService;
    @Test
    void findStudentLike() {
        ResponseResult responseResult = userAccountService.findStudentLike("曹");
        System.out.println(responseResult);
    }
}
package com.soft1851.smart.campus.service;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/22
 * @Version 1.0
 */
@Resource
class UserAccountServiceTest {
    @Resource
    private UserAccountService userAccountService;

    @Test
    void exportTeacherInfo() {
        userAccountService.exportTeacherInfo();
    }
}
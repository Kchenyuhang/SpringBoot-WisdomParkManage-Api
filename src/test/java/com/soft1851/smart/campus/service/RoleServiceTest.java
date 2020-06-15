package com.soft1851.smart.campus.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/15
 * @Version 1.0
 */
@SpringBootTest
class RoleServiceTest {
    @Resource
    private RoleService roleService;

    @Test
    void getRoleMenuByRoleId() {
        System.out.println(roleService.getRoleMenuByRoleId((long)2));
    }
}
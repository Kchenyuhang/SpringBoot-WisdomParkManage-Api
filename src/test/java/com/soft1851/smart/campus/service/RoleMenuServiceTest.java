package com.soft1851.smart.campus.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleMenuServiceTest {

    @Resource
    private RoleMenuService roleMenuService;

    @Test
    void getRoleMenuByRoleId() {
        roleMenuService.getRoleMenuByRoleId(1);
    }
}
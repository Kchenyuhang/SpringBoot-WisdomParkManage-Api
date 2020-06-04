package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysRoleMenuRepositoryTest {

    @Resource
    private SysRoleMenuRepository sysRoleMenuRepository;

    @Test
    void getRoleChildMenuByPkRoleId() {
        Object[] roleMenuByPkRoleId = sysRoleMenuRepository.getRoleMenuByPkRoleId(1);
        for (int i = 0; i < roleMenuByPkRoleId.length; i++) {
            System.out.println(roleMenuByPkRoleId[i]);
        }
    }
}
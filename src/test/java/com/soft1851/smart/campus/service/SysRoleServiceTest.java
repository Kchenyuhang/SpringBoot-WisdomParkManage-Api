package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
class SysRoleServiceTest {

    @Resource
    private SysRoleService sysRoleService;

    @Test
    void deletedSysRole() {
        ResponseResult responseResult = sysRoleService.deletedSysRole(3L);
        System.out.println(responseResult);
    }

    @Test
    void deletedBatch() {
        String ids = "";
        ResponseResult responseResult = sysRoleService.deletedBatch(ids);
        System.out.println(responseResult);
    }

    @Test
    void updateSysRole() {
        SysRole sysRole = SysRole.builder()
                .pkRoleId(2L)
                .roleDecoration("测试超级管理员")
                .roleName("SuperAdmin")
                .isDeleted(false)
                .build();
        ResponseResult responseResult = sysRoleService.updateSysRole(sysRole);
        System.out.println(responseResult);

    }

    @Test
    void increaseSysRole() {
        SysRole sysRole = SysRole.builder()
                .roleDecoration("TestAdmin")
                .roleName("测试管理")
                .build();
        ResponseResult responseResult = sysRoleService.increaseSysRole(sysRole);
        System.out.println(responseResult);
    }

    @Test
    void updateSysRoleSort() {
        ResponseResult responseResult = sysRoleService.updateSysRoleSort("1,6,2,10,12,11");
        System.out.println(responseResult);
    }
}
package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserRoleRepositoryTest {
    @Resource
    private UserRoleRepository userRoleRepository;
    @Resource
    private SysUserRepository sysUserRepository;


    @Test
    void deleteBySysUserId() {
        userRoleRepository.deleteBySysUserId("7b302a4d-a3a1-457d-8a17-42c917dc98a1");
    }


    @Test
    void testFindUserRoleBySysUserId() {
       /* UserRole userRole = userRoleRepository.findUserRoleBySysUserId("5b3a78d7-a290-403f-9b01-874013f53717");
        System.out.println(userRole);*/
        System.out.println(sysUserRepository.getSysUserBySysUserPhoneNumber("123"));
    }
}
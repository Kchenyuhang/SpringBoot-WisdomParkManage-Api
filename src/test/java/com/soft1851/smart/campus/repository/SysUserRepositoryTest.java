package com.soft1851.smart.campus.repository;

import com.alibaba.fastjson.JSON;
import com.soft1851.smart.campus.model.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
class SysUserRepositoryTest {

    @Resource
    private SysUserRepository sysUserRepository;

    @Test
    void selectAdminById() {
        Map admin = sysUserRepository.selectAdminById("1");
        System.out.println(JSON.toJSON(admin));
    }

    @Test
    void deleteByPkUserId() {
        sysUserRepository.deleteByPkUserId("7b302a4d-a3a1-457d-8a17-42c917dc98a1");
    }

    @Test
    void findSysUserByPkUserId() {
        SysUser sysUser = sysUserRepository.findSysUserByPkUserId("1");
        System.out.println(sysUser);
    }
}
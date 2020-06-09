package com.soft1851.smart.campus.repository;

import io.lettuce.core.ScriptOutputType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/3
 * @Version 1.0
 */
@SpringBootTest
class SysUserRoleRepositoryTest {
    @Resource
    private SysUserRoleRepository sysUserRoleRepository;

    @Test
    void getRoleIdByPhoneNumber() {
        System.out.println(sysUserRoleRepository.getRoleIdByPhoneNumber("17826012342"));
    }
}
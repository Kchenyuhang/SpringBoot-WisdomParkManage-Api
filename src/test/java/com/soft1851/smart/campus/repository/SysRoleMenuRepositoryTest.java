package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysRoleMenu;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/16
 * @Version 1.0
 */
@SpringBootTest
class SysRoleMenuRepositoryTest {
    @Resource
    private SysRoleMenuRepository sysRoleMenuRepository;

    @Test
    void getRoleMenuId() {
        System.out.println(sysRoleMenuRepository.getRoleMenuId(1, 2));
    }
}
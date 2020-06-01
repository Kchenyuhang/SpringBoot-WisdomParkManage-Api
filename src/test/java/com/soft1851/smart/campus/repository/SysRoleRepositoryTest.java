package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SysRoleRepositoryTest {

    @Resource
    private SysRoleRepository sysRoleRepository;

    @Test
    void findAllRole() {
        List<SysRole> sysRoleList =  sysRoleRepository.findAllRole();
        System.out.println(sysRoleList);
    }


    /**
     * 测试删除
     */
    @Test
    void deleted() {
        sysRoleRepository.deleteById(3L);
    }


    @Test
    void findByPkRoleId() {
        SysRole sysRole = sysRoleRepository.findByPkRoleId(3L);
        System.out.println(sysRole!=null);
    }

    /**
     * 批量删除
     */
    @Test
    void deleteBatch() {
        List<Long> ids = new ArrayList<Long>();
        ids.add(3L);
        ids.add(4L);
        ids.add(5L);
        sysRoleRepository.deleteBatch(ids);
    }

    @Test
    void name() {
        SysRole sysRole = SysRole.builder()
                .roleName("testAdmin")
                .roleDecoration("测试管理")
                .isDeleted(true)
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .sort(3)
                .build();
        sysRoleRepository.save(sysRole);
    }

    @Test
    void findTopByOrderBySortDesc() {
        SysRole sysRole = sysRoleRepository.findTopByOrderBySortDesc();
        System.out.println(sysRole);
    }
}
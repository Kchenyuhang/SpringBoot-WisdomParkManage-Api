package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.UpdateSysRoleDto;
import com.soft1851.smart.campus.model.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysRoleRepositoryTest {

    @Resource
    private SysRoleRepository sysRoleRepository;

    @Test
    void deleteBatchByPkRoleId() {
        List<Long> ids = new ArrayList<>();
        ids.add((long)1);
        ids.add((long)2);
        int a= sysRoleRepository.deleteBatchByPkRoleId(ids);
        System.out.println(a);
    }


    @Test
    void findAllRole() {
        List<SysRole> sysRoleList = sysRoleRepository.findAllRole();
        System.out.println(sysRoleList);
    }

    @Test
    void updateSysRole() {
        UpdateSysRoleDto updateSysRoleDto = UpdateSysRoleDto.builder()
                .pkRoleId((long)2)
                .roleName("A级管理员")
                .roleDecoration("管理角色模块")
                .isDeleted(false)
                .build();
        sysRoleRepository.updateSysRole(updateSysRoleDto);
    }
}
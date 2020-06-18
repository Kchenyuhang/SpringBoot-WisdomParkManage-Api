package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
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

    @Test
    void getAllSysRole() {
        PageDto pageDto = PageDto.builder()
                .currentPage(0)
                .pageSize(1)
                .build();

        ResponseResult responseResult = sysRoleService.getAllSysRole(pageDto);

    }

    @Test
    void findAllSysRole() {
        ResponseResult responseResult = sysRoleService.findAllSysRole();
        System.out.println(responseResult);
    }

    @Test
    void batchDelete(){
        //System.out.println(sysRoleService.deleteRoleMenu("[70,71,72]"));
    }
}
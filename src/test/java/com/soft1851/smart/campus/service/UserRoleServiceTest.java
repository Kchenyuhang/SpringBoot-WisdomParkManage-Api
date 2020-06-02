package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.AdminDto;
import com.soft1851.smart.campus.model.dto.AdminUpdateDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserRoleServiceTest {

    @Resource
    private UserRoleService userRoleService;

    @Test
    void selectAllAdmin() {
        ResponseResult responseResult = userRoleService.selectAllAdmin();
        System.out.println(responseResult);
    }

    @Test
    void increaseAdmin() {
        AdminDto adminDto = AdminDto.builder()
                .sysPassword("123456")
                .sysUserName("陶")
                .sysUserPhoneNumber("13270003519")
                .roleId((long) 1)
                .build();
        ResponseResult responseResult = userRoleService.increaseAdmin(adminDto);
        System.out.println(responseResult);

    }

    @Test
    void deletedAdmin() {
        ResponseResult responseResult = userRoleService.deletedAdmin("5b3a78d7-a290-403f-9b01-874013f53717");
        System.out.println(responseResult);
    }

    @Test
    void modificationAdmin() {
        AdminUpdateDto adminUpdateDto = AdminUpdateDto.builder()
                .pkUserId("78bc8d7c-edda-4682-8e20-40bf5e532b27")
                .sysUserName("陶陶陶")
                .sysPassword("1515")
                .isEnabled(false)
                .build();
        userRoleService.modificationAdmin(adminUpdateDto);
    }
}
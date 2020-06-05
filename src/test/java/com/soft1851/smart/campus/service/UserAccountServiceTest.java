package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest

class UserAccountServiceTest {

    @Resource
    public UserAccountService userAccountService;
    @Test
    void insertUserAccount() {
    }

    @Test
    void findAllUserAccount() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(2)
                .build();
        ResponseResult result = userAccountService.findAllUserAccount(pageDto);
        System.out.println(result);
    }

    @Test
    void deleteUserAccount() {
    }

    @Test
    void deletedBatch() {
    }

    @Test
    void updateUserAccount() {
    }
}
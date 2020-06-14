package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserAccountServiceTest {

    @Resource
    private UserAccountService userAccountService;
    @Test
    void insertUserAccount() {
        UserAccount userAccount = UserAccount.builder()
                .jobNumber("110110110")
                .address("江苏省-南京市-栖霞区")
                .clazzId(1)
                .gender("男")
                .phoneNumber("17826043211")
                .userName("陶永新")
                .build();
        ResponseResult responseResult= userAccountService.insertUserAccount(userAccount);
        System.out.println(responseResult);

    }
}
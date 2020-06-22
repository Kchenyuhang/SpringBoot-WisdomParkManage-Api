package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserAccountServiceTest {

    @Resource
    private UserAccountService userAccountService;

    @Test
    void insertUserAccount() {
        UserAccount userAccount = UserAccount.builder()
                .role("1")
                .clazzId((long)10)
                .address("江苏省-南京市-栖霞区")
                .phoneNumber("13270003526")
                .jobNumber("1802313117")
                .userName("陶永新6.22")
                .gender("男")
                .build();
        userAccountService.insertUserAccount(userAccount);
    }
}
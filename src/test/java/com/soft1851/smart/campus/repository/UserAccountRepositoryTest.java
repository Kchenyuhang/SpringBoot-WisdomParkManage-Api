package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserAccountRepositoryTest {

    @Resource
    private UserAccountRepository userAccountRepository;

    @Test
    void getUserName() {
        System.out.println(userAccountRepository.getUserName("1802343124"));
    }
}
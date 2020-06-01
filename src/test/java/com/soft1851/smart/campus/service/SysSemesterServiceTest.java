package com.soft1851.smart.campus.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysSemesterServiceTest {

    @Resource
    private SysSemesterService sysSemesterService;

    @Test
    void findAll() {
        sysSemesterService.findAll().forEach(System.out::println);
    }
}
package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysSubjectRepositoryTest {

    @Resource
    private SysSubjectRepository sysSubjectRepository;

    @Test
    void getSubjectName() {
        System.out.println(sysSubjectRepository.getSubjectName(1L));
    }
}
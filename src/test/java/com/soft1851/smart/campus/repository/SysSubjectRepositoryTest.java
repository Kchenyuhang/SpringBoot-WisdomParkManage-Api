package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class SysSubjectRepositoryTest {

    @Resource
    private SysSubjectRepository sysSubjectRepository;

    @Test
    void getSubjectName() {
        System.out.println(sysSubjectRepository.getSubjectName(1L));
    }

    @Test
    void getSubjectBackground() {
        System.out.println(sysSubjectRepository.getSubjectBackgroundColor(1L));
    }
}
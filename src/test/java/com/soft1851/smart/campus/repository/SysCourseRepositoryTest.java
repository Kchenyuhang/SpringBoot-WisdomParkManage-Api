package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysCourseRepositoryTest {

    @Resource
    private SysCourseRepository sysCourseRepository;

    @Test
    void getIdInfo() {
        sysCourseRepository.getInfoOfId(1L).forEach(System.out::println);
    }

}
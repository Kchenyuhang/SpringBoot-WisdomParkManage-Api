package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class SysCourseRepositoryTest {

    @Resource
    private SysCourseRepository sysCourseRepository;

    @Test
    void getInfoOfId() {
        sysCourseRepository.getInfoOfId(1L).forEach(System.out::println);
    }
}
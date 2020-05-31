package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysCourse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysCourseRepositoryTest {

    @Resource
    private SysCourseRepository sysCourseRepository;

    @Test
    void getInfoOfId() {
        sysCourseRepository.getInfoOfId(1L).forEach(System.out::println);
    }
}
package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduleRepositoryTest {

    @Resource
    private ScheduleRepository scheduleRepository;

    @Test
    void getId() {
        System.out.println(scheduleRepository.getId(1L, 1L, 1));
    }
}
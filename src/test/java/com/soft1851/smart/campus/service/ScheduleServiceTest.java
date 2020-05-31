package com.soft1851.smart.campus.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduleServiceTest {

    @Resource
    private ScheduleService scheduleService;

    @Test
    void getScheduleInfo() {
        scheduleService.getScheduleInfo(1L, 1L, 1).forEach(System.out::println);
    }
}
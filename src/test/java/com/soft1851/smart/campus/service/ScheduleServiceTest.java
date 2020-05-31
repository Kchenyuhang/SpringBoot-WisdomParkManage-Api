package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.SysCourse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class ScheduleServiceTest {

    @Resource
    private ScheduleService scheduleService;

    @Test
    void getScheduleInfo() {
        scheduleService.getScheduleInfo(1L, 1L, 1).forEach(System.out::println);
    }

    @Test
    void increase() {
        SysCourse course = SysCourse.builder()
                .scheduleId(10L)
                .subjectId(10L)
                .userJobNumber("测试")
                .roomId(10)
                .weekDay(10)
                .time(5)
                .weekDuration("1-5")
                .build();
        scheduleService.increase(course);
    }
}
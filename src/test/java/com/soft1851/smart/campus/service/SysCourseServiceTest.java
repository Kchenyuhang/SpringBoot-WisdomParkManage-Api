package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.SysCourse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysCourseServiceTest {

    @Resource
    private SysCourseService sysCourseService;

    @Test
    void increase() {
        SysCourse course = SysCourse.builder()
                .scheduleId(10L)
                .subjectId(10L)
                .userJobNumber("测试增加课程的service方法")
                .roomId(10)
                .weekDay(10)
                .time(5)
                .weekDuration("1-5")
                .build();
        sysCourseService.increase(course);
    }
}
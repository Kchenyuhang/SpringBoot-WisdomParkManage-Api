package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.Schedule;
import com.soft1851.smart.campus.model.entity.SysCourse;
import com.soft1851.smart.campus.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;


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
        Timestamp timestamp = DateUtil.getTimestamp();
        Schedule schedule = Schedule.builder()
                .clazzId(1L)
                .gmtCreate(timestamp)
                .gmtModified(timestamp)
                .isDeleted(false)
                .name("测试增加课表service方法")
                .semesterId(1L)
                .week(10)
                .build();
        scheduleService.increase(schedule);
    }

    @Test
    void testGetScheduleInfo() {
        scheduleService.getScheduleInfo(1L, 1L, 1).forEach(System.out::println);
    }
}
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
    void getIdInfo() {
        sysCourseRepository.getInfoOfId(1L).forEach(System.out::println);
    }


    @Test
    void getInfoOfId() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        SysCourse course = SysCourse.builder()
                .scheduleId(10L)
                .subjectId(10L)
                .userJobNumber("1802343124")
                .roomId(10)
                .weekDay(10)
                .time(5)
                .gmtCreate(timestamp)
                .gmtModified(timestamp)
                .isDeleted(false)
                .weekDuration("1-5")
                .build();
        sysCourseRepository.insertCourse(course);
    }
}
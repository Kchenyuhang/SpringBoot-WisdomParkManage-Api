package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.Date;


@SpringBootTest
class ExaminationServiceTest {

    @Resource
    private ExaminationService examinationService;

    @Test
    void updateInfo() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Examination examination = Examination.builder()
                .pkExaminationId(1L)
                .area("测试")
                .clazzId(1L)
                .gmtCreate(timestamp)
                .gmtModified(timestamp)
                .isDeleted(false)
                .score(100)
                .semester("2019-2020 第一学期")
                .startTime(timestamp)
                .subjectId(1L)
                .teacherName("张老师")
                .type("选修课")
                .build();
        examinationService.updateInfo(examination);
    }

    @Test
    void increaseInfo() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Examination examination = Examination.builder()
                .area("测试新增考务数据")
                .clazzId(1L)
                .gmtCreate(timestamp)
                .gmtModified(timestamp)
                .isDeleted(false)
                .score(100)
                .semester("2019-2020 第一学期")
                .startTime(timestamp)
                .subjectId(1L)
                .teacherName("张老师")
                .type("选修课")
                .build();
        examinationService.increaseInfo(examination);
    }
}
package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.Examination;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExaminationRepositoryTest {

    @Resource
    private ExaminationRepository examinationRepository;

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
        examinationRepository.updateInfo(examination);
    }
}
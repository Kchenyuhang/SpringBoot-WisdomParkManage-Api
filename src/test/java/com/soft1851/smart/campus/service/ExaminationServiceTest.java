package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.Examination;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;

@SpringBootTest
class ExaminationServiceTest {

    @Resource
    private ExaminationService examinationService;

    @Test
    void increaseInfo() {
        String startTime = "2020-06-28 06:30:00";
        Timestamp startTime1 = Timestamp.valueOf(startTime);
        String finishTime = "2020-06-28 08:40:00";
        Timestamp finishTime1 = Timestamp.valueOf(finishTime);
        Examination examination = Examination.builder()
                .semester("2012-2013学年第一学期")
                .subjectId((long)19)
                .teacherName("赵岩")
                .type("线上考试")
                .startTime(startTime1)
                .finishTime(finishTime1)
                .area("教四408")
                .score(150)
                .clazzId((long)2)
                .build();
        ResponseResult responseResult = examinationService.increaseInfo(examination);
        System.out.println(responseResult);
    }

}
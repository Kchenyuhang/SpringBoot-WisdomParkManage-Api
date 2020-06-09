package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.utils.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;


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
                .testPeriod("2020-05-09 05:56:20~2020-05-09 06:56:20")
                .subjectId(1L)
                .teacherName("张老师")
                .type("选修课")
                .build();
        examinationService.updateInfo(examination);
    }

    @Test
    void increaseInfo() {
        String[] semester = {
                "2011-2012学年第二学期",
                "2011-2012学年第一学期",
                "2012-2013学年第二学期",
                "2012-2013学年第一学期",
                "2013-2014学年第二学期",
                "2013-2014学年第一学期",
                "2014-2015学年第二学期",
                "2014-2015学年第一学期",
                "2015-2016学年第二学期",
                "2015-2016学年第一学期",
                "2016-2017学年第二学期",
                "2016-2017学年第一学期",
                "2017-2018学年第二学期",
                "2017-2018学年第一学期",
                "2018-2019学年第二学期",
                "2018-2019学年第一学期",
                "2019-2020学年第二学期",
                "2019-2020学年第一学期"
        };
        String[] type = {"笔试", "线上考试", "实训考核"};
        for (int i = 0; i < 100; i++) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Examination examination = Examination.builder()
                    .area("测试地点" + i)
                    .clazzId(1L)
                    .gmtCreate(timestamp)
                    .gmtModified(timestamp)
                    .isDeleted(false)
                    .score(150)
                    .semester(semester[i % 18])
                    .testPeriod("2020-05-09 05:56:20~2020-05-09 06:56:20")
                    .subjectId(1L)
                    .teacherName("张老师")
                    .type(type[i % 3])
                    .finishTime(timestamp)
                    .build();
            examinationService.increaseInfo(examination);
        }

    }

    @Test
    void findAllByPage() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(5)
                .build();
        System.out.println("***************");
        examinationService.findAllByPage(pageDto).forEach(System.out::println);
    }

    @Test
    void countNum() {
        examinationService.countNum();
    }
}
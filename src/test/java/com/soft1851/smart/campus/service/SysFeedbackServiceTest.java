package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.TimeBorrowPageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SysFeedbackServiceTest {

    @Resource
    private SysFeedbackService sysFeedbackService;

    @Test
    void findAllSysFeedback() {
        PageDto pageDto = PageDto.builder()
                .currentPage(0)
                .pageSize(3)
                .build();
        ResponseResult responseResult = sysFeedbackService.findAllSysFeedback(pageDto);
        System.out.println(responseResult);
    }

    @Test
    void getSysFeedbackByTime() {
        String startTime = "2020-06-14 00:52:34";
        String endTime = "2020-06-18 00:52:34";
        TimeBorrowPageDto timeBorrowPageDto = TimeBorrowPageDto.builder()
                .time("['2020-06-04 00:00:00','2020-06-29 00:00:00']")
                .currentPage(1)
                .pageSize(1)
                .build();
        System.out.println(sysFeedbackService.getSysFeedbackByTime(timeBorrowPageDto));
    }
}
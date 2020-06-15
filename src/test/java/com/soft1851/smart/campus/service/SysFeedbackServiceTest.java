package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
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
}
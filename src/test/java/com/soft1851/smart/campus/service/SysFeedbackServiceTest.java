package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysFeedback;
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
    void increaseSysFeedback() {
        SysFeedback sysFeedback = SysFeedback.builder()
                .title("111")
                .content("2222")
                .contactWay("13092037352")
                .build();
        ResponseResult responseResult = sysFeedbackService.increaseSysFeedback(sysFeedback);
        System.out.println(responseResult);
    }

    @Test
    void modificationSysFeedback() {
        SysFeedback sysFeedback = SysFeedback.builder()
                .pkFeedbackId((long)41)
                .title("987")
                .isHandled(false)
                .content("987")
                .build();
        ResponseResult responseResult = sysFeedbackService.modificationSysFeedback(sysFeedback);
        System.out.println(responseResult);
    }

    @Test
    void deletionSysFeedback() {
        ResponseResult responseResult = sysFeedbackService.deletionSysFeedback((long)41);
        System.out.println(responseResult);
    }

    @Test
    void deletedBatch() {
        ResponseResult responseResult = sysFeedbackService.deletedBatch("39,40");
        System.out.println(responseResult);
    }
}
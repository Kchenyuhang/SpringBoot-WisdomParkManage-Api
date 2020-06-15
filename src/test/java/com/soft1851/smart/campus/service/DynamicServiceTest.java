package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DynamicServiceTest {
    @Resource
    private DynamicService dynamicService;

    @Test
    void insertDynamic() {
    }

    @Test
    void findAllDynamic() {
        PageDto pageDto = PageDto.builder()
                .currentPage(0)
                .pageSize(2)
                .build();
        ResponseResult result = dynamicService.findAllDynamic(pageDto);
        System.out.println(result);
    }

    @Test
    void deleteDynamic() {
        dynamicService.deleteDynamic("1271346795213361152");
    }

    @Test
    void deletedBatch() {
    }

    @Test
    void updateDynamic() {
    }
}
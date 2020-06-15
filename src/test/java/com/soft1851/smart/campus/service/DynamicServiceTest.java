package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.DynamicDto;
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
        DynamicDto dynamic = DynamicDto.builder()
                .content("不是吧，啊sir，今天喝了脉动啊，吃了果冻啊，还是忍不住对你心动呀@")
                .userId("1")
                .type("吐槽爆料")
                .build();
        dynamicService.insertDynamic(dynamic);
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
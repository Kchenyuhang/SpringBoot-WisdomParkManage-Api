package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.InfoType;
import com.soft1851.smart.campus.repository.InfoTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class InfoTypeServiceTest {

    @Resource
    private InfoTypeRepository infoTypeRepository;

    @Resource
    private InfoTypeService infoTypeService;
    @Test
    void insertInfoType() {
        InfoType infoType = InfoType.builder()
                .name("军事")
                .build();
        infoTypeService.insertInfoType(infoType);


    }

    @Test
    void deleteInfoType() {
    }

    @Test
    void updateInfoType() {
    }
}
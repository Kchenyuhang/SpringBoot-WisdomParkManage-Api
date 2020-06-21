package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.QueryDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InfoManageServiceTest {

    @Resource
    private InfoManageService infoManageService;

    @Test
    void findAllInfo() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(3)
                .build();
        ResponseResult responseResult = infoManageService.findAllInfo(pageDto);
        System.out.println(responseResult);
    }

    @Test
    void changeInfoMange() {
        QueryDto queryDto = QueryDto.builder()
                .filed1("2")
                .status(true)
                .build();
        infoManageService.changeInfoMange(queryDto);
    }
}
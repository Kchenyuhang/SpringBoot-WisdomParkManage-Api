package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.InfoManage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class InfoManageServiceTest {
    @Resource
    private InfoManageService infoManageService;

    @Test
    void findAllInfo() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(2)
                .build();
        ResponseResult result = infoManageService.findAllInfo(pageDto);
        System.out.println(result);
    }

    @Test
    void deletedSysRole() {
        ResponseResult responseResult = infoManageService.deleteInfoManage(200L);
        System.out.println(responseResult);
    }
    @Test
    void deletedBatch() {
        String ids = "";
        ResponseResult responseResult = infoManageService.deletedBatch(ids);
        System.out.println(responseResult);

    }

    @Test
    void updateSysRole() {
        InfoManage infoManage = InfoManage.builder()
                .pkInfoManageId(3L)
                .title("修改")
                .cover("zzz.jpg")
                .text("修改内容")
                .isTop(true)
                .isDeleted(true)
                .build();
        ResponseResult result = infoManageService.updateInfoManage(infoManage);
        System.out.println(result);
    }
}
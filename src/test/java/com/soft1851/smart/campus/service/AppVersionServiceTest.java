package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.AppVersion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AppVersionServiceTest {
    @Resource
    private AppVersionService appVersionService;
    @Test
    void increaseAppVersion() {
        AppVersion appVersion = AppVersion.builder()
                .appType("鸿蒙")
                .currentVersion("2.1")
                .versionDescription("简介~")
                .downloadLink("https://wwww.souhu.com")
                .build();
        ResponseResult responseResult = appVersionService.increaseAppVersion(appVersion);
        System.out.println(responseResult);
    }

    @Test
    void findAllAppVersion() {
        PageDto pageDto = PageDto.builder()
                .currentPage(0)
                .pageSize(5)
                .build();
        ResponseResult responseResult = appVersionService.findAllAppVersion(pageDto);
        System.out.println(responseResult);
    }

    @Test
    void deletionAppVersion() {
        ResponseResult responseResult = appVersionService.deletionAppVersion((long)3);
        System.out.println(responseResult);
    }

    @Test
    void deletedBatch() {
        ResponseResult responseResult = appVersionService.deletedBatch("2,4,51");
        System.out.println(responseResult);
    }

    @Test
    void testDeletionAppVersion() {
        ResponseResult responseResult = appVersionService.deletionAppVersion((long)103);
        System.out.println(responseResult);
    }

    @Test
    void testDeletedBatch() {
        ResponseResult responseResult = appVersionService.deletedBatch("48,50");
        System.out.println(responseResult);
    }
}
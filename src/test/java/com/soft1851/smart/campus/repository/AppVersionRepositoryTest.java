package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.UpdateAppVersionDto;
import com.soft1851.smart.campus.model.entity.AppVersion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AppVersionRepositoryTest {

    @Resource
    private AppVersionRepository appVersionRepository;


    @Test
    void name() {
        List<AppVersion> appVersions = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            AppVersion appVersion = AppVersion.builder()
                    .appType("安卓")
                    .currentVersion("1." + i)
                    .minVersion("1.0")
                    .maxVersion("1.49")
                    .versionDescription("当前版本的描述为：" + i)
                    .downloadLink("https://www.baidu.com/")
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(false)
                    .build();

            appVersions.add(appVersion);
        }
        appVersionRepository.saveAll(appVersions);
    }

    @Test
    void selectAllPkAppVersionId() {
        List<Long> ids = appVersionRepository.selectAllPkAppVersionId();
        System.out.println(ids);
    }

    @Test
    void updateMaxVersion() {
        List<Long> ids = new ArrayList<>();
        ids.add((long) 48);
        ids.add((long) 49);
        ids.add((long) 50);
        int a = appVersionRepository.updateMaxVersion("5.20", ids);
        System.out.println(a);

    }

    @Test
    void deleteBatch() {
        List<Long> ids = new ArrayList<>();
        ids.add((long) 5);
        ids.add((long) 6);
        ids.add((long) 7);
        int a = appVersionRepository.deleteBatchAppVersion(ids);
        System.out.println(a);
    }

    @Test
    void isDeleted() {
        appVersionRepository.setIsDeletedByPkAppVersionId((long) 6);
    }


    @Test
    void findMinVersion() {
        AppVersion findMaxVersion = appVersionRepository.findMinVersionMessage();
        System.out.println(findMaxVersion);
    }

    @Test
    void updateAppVersion() {
        UpdateAppVersionDto updateAppVersionDto = UpdateAppVersionDto.builder()
                .pkAppVersionId((long)5)
                .downloadLink("www.baidu.com")
                .versionDescription("测试简介")
                .appType("鸿蒙")
                .build();
        appVersionRepository.updateAppVersion(updateAppVersionDto);
    }
}
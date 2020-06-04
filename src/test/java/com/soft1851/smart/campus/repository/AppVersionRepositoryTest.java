package com.soft1851.smart.campus.repository;

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
    void findTopByOrderByPkAppVersionIdDesc() {
        AppVersion appVersion = appVersionRepository.findTopByOrderByPkAppVersionIdDesc();
        System.out.println(appVersion);
    }

    @Test
    void name() {
        List<AppVersion> appVersions = new ArrayList<>();
        for (int i=0 ;i<50 ;i++){
            AppVersion appVersion = AppVersion.builder()
                    .appType("安卓")
                    .currentVersion("1."+i)
                    .minVersion("1.0")
                    .maxVersion("1.49")
                    .versionDescription("当前版本的描述为："+i)
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
        ids.add((long)48);
        ids.add((long)49);
        ids.add((long)50);
        int a = appVersionRepository.updateMaxVersion("5.20",ids);
        System.out.println(a);

    }
}
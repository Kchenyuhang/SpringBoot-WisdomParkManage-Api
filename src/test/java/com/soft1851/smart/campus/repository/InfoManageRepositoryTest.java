package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class InfoManageRepositoryTest {

    @Resource
    private InfoManageRepository infoManageRepository;

    @Test
    void name() {
        infoManageRepository.changeIsTop((long)2,true);
    }
}
package com.soft1851.smart.campus.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/16
 * @Version 1.0
 */
@SpringBootTest
class TowerServiceTest {
    @Resource
    private TowerService towerService;

    @Test
    void getAllUnitByTowerId() {
        System.out.println(towerService.getAllUnitByTowerId());
    }
}
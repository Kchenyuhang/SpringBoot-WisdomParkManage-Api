package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.Tower;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
@SpringBootTest
class TowerRepositoryTest {
    @Resource
    private TowerRepository towerRepository;

    @Test
    void updateTowerByTowerId() {
        List<Tower> towers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Tower tower = Tower.builder()
                    .latitude("测试经度" + i)
                    .longitude("测试纬度" + i)
                    .name("测试楼栋" + i)
                    .type(new Random().nextInt(2))
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(false)
                    .build();
            towers.add(tower);
        }
        towerRepository.saveAll(towers);

    }
}
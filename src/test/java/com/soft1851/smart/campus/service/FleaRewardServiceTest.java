package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.dto.FleaRewardBatchIdDto;
import com.soft1851.smart.campus.model.dto.FleaRewardIdDto;
import com.soft1851.smart.campus.repository.FleaRewardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/6/12
 */
@SpringBootTest
@Slf4j
class FleaRewardServiceTest {
    @Resource
    private FleaRewardService fleaRewardService;

    @Test
    void deleteOneById() {
        FleaRewardIdDto fleaRewardIdDto = new FleaRewardIdDto();
        fleaRewardIdDto.setFleaRewardId(15L);
        log.info(String.valueOf(fleaRewardService.deleteOneById(fleaRewardIdDto)));
    }

    @Test
    void batchDeleteById() {
        FleaRewardBatchIdDto fleaRewardBatchIdDto = new FleaRewardBatchIdDto();
        List<Long> batchId = new ArrayList<>();
        batchId.add(5L);
        batchId.add(10L);
        batchId.add(11L);
        fleaRewardBatchIdDto.setId(batchId);
        System.out.println(fleaRewardService.batchDeleteById(fleaRewardBatchIdDto));
    }
}
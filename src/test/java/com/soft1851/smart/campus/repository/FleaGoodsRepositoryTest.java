package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.FleaOrderBatchIdDto;
import com.soft1851.smart.campus.model.dto.FleaRewardBatchIdDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FleaGoodsRepositoryTest {
    @Resource
    private FleaGoodsRepository goodsRepository;
    @Test
    void batchLogicalDel() {
        FleaRewardBatchIdDto rewardBatchIdDto = new FleaRewardBatchIdDto();
        List<Long> idList = new ArrayList<>();
        idList.add(4l);
        idList.add(5l);
        rewardBatchIdDto.setId(idList);
        System.out.println(goodsRepository.batchLogicalDel(rewardBatchIdDto.getId()));
    }
}
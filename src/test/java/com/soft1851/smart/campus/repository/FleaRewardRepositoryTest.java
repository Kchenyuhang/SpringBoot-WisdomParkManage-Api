package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.FleaRewardBatchIdDto;
import com.soft1851.smart.campus.model.entity.FleaReward;
import com.soft1851.smart.campus.model.vo.FleaRewardVo;
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
class FleaRewardRepositoryTest {
    @Resource
    private FleaRewardRepository fleaRewardRepository;

    @Test
    void deleteRewardByPkRewardId() {
        System.out.println(fleaRewardRepository.deleteRewardByPkRewardId(1L));
    }

    @Test
    void batchDelete() {
        FleaRewardBatchIdDto fleaRewardBatchIdDto = new FleaRewardBatchIdDto();
        List<Long> idList = new ArrayList<>();
        idList.add(12L);
        idList.add(13L);
        idList.add(14L);
        fleaRewardBatchIdDto.setId(idList);
        System.out.println(fleaRewardRepository.batchDelete(fleaRewardBatchIdDto.getId()));
    }

    @Test
    void findAll() {
//        List<FleaRewardVo> fleaRewardVos = fleaRewardRepository.findAllFleaReward();
//        fleaRewardVos.forEach(System.out::println);
    }
}
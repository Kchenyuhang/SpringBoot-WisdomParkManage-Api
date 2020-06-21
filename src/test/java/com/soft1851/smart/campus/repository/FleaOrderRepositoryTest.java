package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.FleaOrderBatchIdDto;
import com.soft1851.smart.campus.model.dto.FleaOrderDto;
import com.soft1851.smart.campus.model.dto.FleaRewardBatchIdDto;
import com.soft1851.smart.campus.model.entity.FleaOrder;
import com.soft1851.smart.campus.model.vo.FleaOrderVo;
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
 * @Date 2020/6/13
 */
@SpringBootTest
@Slf4j
class FleaOrderRepositoryTest {
    @Resource
    private FleaOrderRepository fleaOrderRepository;

    @Test
    void logicalDel() {
        System.out.println(fleaOrderRepository.logicalDel("1"));
    }

    @Test
    void batchLogicalDel() {
//        FleaRewardBatchIdDto fleaOrderBatchIdDto = new FleaRewardBatchIdDto();
//        List<Long> idList = new ArrayList<>();
//        idList.add(4l);
//        idList.add(5l);
//        fleaOrderBatchIdDto.setId(idList);
//        System.out.println(fleaOrderRepository.batchLogicalDel(fleaOrderBatchIdDto.getId()));
    }

    @Test
    void findAll() {
//        List<FleaOrderVo> fleaOrderVos = fleaOrderRepository.findAllOrder();
//        fleaOrderVos.forEach(System.out::println);
    }
}
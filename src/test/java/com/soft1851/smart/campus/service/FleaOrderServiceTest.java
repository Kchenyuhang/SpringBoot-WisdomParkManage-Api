package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.dto.FleaOrderBatchIdDto;
import com.soft1851.smart.campus.model.dto.FleaOrderDto;
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
class FleaOrderServiceTest {
    @Resource
    private FleaOrderService fleaOrderService;

    @Test
    void logicalDel() {
        FleaOrderDto fleaOrderDto = new FleaOrderDto();
        fleaOrderDto.setPkFleaOrderId("20202020");
        log.info(String.valueOf(fleaOrderService.logicalDel(fleaOrderDto)));
    }

    @Test
    void batchLogicalDel() {
        FleaOrderBatchIdDto fleaOrderBatchIdDto = new FleaOrderBatchIdDto();
        List<String> batchId = new ArrayList<>();
        batchId.add("1");
        batchId.add("2");
        batchId.add("3");
        fleaOrderBatchIdDto.setId(batchId);
        System.out.println(fleaOrderService.batchLogicalDel(fleaOrderBatchIdDto));
    }
}
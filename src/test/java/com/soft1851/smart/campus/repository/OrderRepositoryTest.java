package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.UpdateOrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderRepositoryTest {

    @Resource
    private OrderRepository orderRepository;
    @Test
    void updateSysOrder() {
        UpdateOrderDto updateOrderDto = UpdateOrderDto.builder()
                .pkOrderId((long)1)
                .orderMoney(25.8)
                .description("一食堂风味二")
                .build();
        orderRepository.updateSysOrder(updateOrderDto);
    }

    @Test
    void deleteByPkOrderId() {
        orderRepository.deleteByPkOrderId((long)1);

    }

    @Test
    void deleteBatch() {
        List<Long> ids = new ArrayList<>();
        ids.add((long) 2);
        ids.add((long) 3);
        ids.add((long) 4);
        orderRepository.deleteBatch(ids);
    }
}
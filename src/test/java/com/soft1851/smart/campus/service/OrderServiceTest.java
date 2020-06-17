package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.UpdateOrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {
    @Resource
    private OrderService orderService;

    @Test
    void updateOrder() {
        UpdateOrderDto updateOrderDto = UpdateOrderDto.builder()
                .pkOrderId((long)1)
                .description("五食堂")
                .orderMoney(33.5).build();
        ResponseResult responseResult = orderService.updateOrder(updateOrderDto);
        System.out.println(responseResult);
    }

    @Test
    void deleteOrder() {
        ResponseResult responseResult = orderService.deleteOrder((long)1);
        System.out.println(responseResult);
    }
}
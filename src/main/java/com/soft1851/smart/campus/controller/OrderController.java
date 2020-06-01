package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.service.OrderService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/29
 **/
@Slf4j
@RestController
@Api(value = "OrderController",tags = {"订单接口"})
public class OrderController {
    @Resource
    private OrderService orderService;
    /**
     * 分页查询所有挂失消息
     * @param pageDto
     * @return
     */
    @PostMapping("/order/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto){
        return orderService.findAllByPage(pageDto);
    }

}
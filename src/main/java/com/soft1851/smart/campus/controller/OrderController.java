package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.QueryDto;
import com.soft1851.smart.campus.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
     * 分页查询所有订单消息
     * @param pageDto
     * @return
     */
    @PostMapping("/order/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto){
        return orderService.getAllSysOrder(pageDto);
    }
    /**
     * 删除订单信息
     * @param queryDto
     * @return
     */
    @PostMapping("/order/id")
    ResponseResult deleteCard(@RequestBody QueryDto queryDto){
        return orderService.deleteOrder(Long.parseLong(queryDto.getField().toString()));
    }
    /**
     * 批量删除订单
     * @return List<card>
     */
    @ApiOperation(value = "批量删除一卡通信息",notes = "")
    @PostMapping(value = "order/deletionBath")
    public ResponseResult deletedBatch(@RequestBody QueryDto queryDto){
        return orderService.deletedBatch(queryDto.getField().toString());
    }

}
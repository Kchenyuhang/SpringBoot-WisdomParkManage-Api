package com.soft1851.smart.campus.service.Impl;


import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.SysOrder;
import com.soft1851.smart.campus.repository.OrderRepository;
import com.soft1851.smart.campus.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/29
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Override
    public ResponseResult findALLByJobNumer(String jobNumber) {
        List<SysOrder> sysOrderList=orderRepository.findAllByJobNumber(jobNumber);

        return ResponseResult.success(sysOrderList);
    }
}
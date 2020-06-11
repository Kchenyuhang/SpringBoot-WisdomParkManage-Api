package com.soft1851.smart.campus.service.Impl;


import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysOrder;
import com.soft1851.smart.campus.repository.OrderRepository;
import com.soft1851.smart.campus.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public ResponseResult findAllByPage(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pk_order_id");
        Page<SysOrder> sysOrders = orderRepository.findAll(pageable);
        return ResponseResult.success(sysOrders.getContent());
    }

    @Override
    public ResponseResult getAllSysOrder(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pk_order_id");
        Page<SysOrder> sysOrders = orderRepository.getAllSysOrder(pageable);
        return ResponseResult.success(sysOrders.getContent());
    }

    @Override
    public ResponseResult deleteOrder(Long pkOrderId) {
        orderRepository.deleteByPkOrderId(pkOrderId);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult deletedBatch(String ids) {
        //判断是否有数据
        if (ids.length() != 0) {
            //将接收到的ids字符串，使用逗号分割
            String[] idArr = ids.split(",");
            List<Long> idsList = new ArrayList<Long>();
            for (String id : idArr) {
                //遍历所有id存入到list
                idsList.add(Long.valueOf(id));
            }
            orderRepository.deleteBatch(idsList);
            return ResponseResult.success("删除成功");
        } else {
            return ResponseResult.failure(ResultCode.PARAM_IS_BLANK);
        }
    }

}
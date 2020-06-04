package com.soft1851.smart.campus.service;


import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/29
 **/
public interface OrderService {
    /**
     * 查询清单明细
     * @param jobNumber
     * @return
     */
    ResponseResult findALLByJobNumer(String jobNumber);
    /**
     * 分页查询订单信息
     * @param pageDto
     * @return
     */
    ResponseResult findAllByPage(PageDto pageDto);

}

package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.FleaOrderDto;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaGoodsService.java
 * @Description TODO
 * @createTime 2020年06月09日 13:58:00
 */
public interface FleaOrderService {
    /**
     * 新增订单
     *
     * @param fleaOrderDto
     * @return
     */
    ResponseResult orderIncreased(FleaOrderDto fleaOrderDto);

    /**
     * 逻辑删除订单
     *
     * @param fleaOrderDto
     * @return
     */
    ResponseResult logicalDel(FleaOrderDto fleaOrderDto);
}

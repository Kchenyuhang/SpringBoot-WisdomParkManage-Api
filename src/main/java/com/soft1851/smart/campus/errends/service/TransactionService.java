package com.soft1851.smart.campus.errends.service;

import java.util.List;

/**
 * @author wl
 * @ClassNameTransactionService
 * @Description TODO
 * @Date 2020/6/26
 * @Version 1.0
 */
public interface TransactionService  {
    /**
     * 获取十五天的订单量
     * @return
     */
    List<Integer> getOrderByFifteenDays();
}

package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName OrderRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/29
 **/
public interface OrderRepository extends JpaRepository<SysOrder, Long> {
    /**
     * 消费明细
     * @param jobNumber
     * @return
     */
    List<SysOrder> findAllByJobNumber(String jobNumber);
}
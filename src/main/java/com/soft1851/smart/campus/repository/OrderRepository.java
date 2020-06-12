package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysOrder;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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
    /**
     * 分页查询未被逻辑查询删除的订单信息数据
     * @return
     */
    @Query(value = "select * from sys_order where is_deleted =false ",nativeQuery = true)
    Page<SysOrder> getAllSysOrder(Pageable pageable);
    /**
     * 根据id删除一卡通信息
     * @param pkOrderId
     * @return
     */
    @Modifying
    @LastModifiedBy
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update sys_order set is_deleted = true where pk_order_id = ?1",nativeQuery = true)
    void deleteByPkOrderId(Long pkOrderId);

    /**
     * 批量删除
     * @param ids
     */
    @Modifying
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Query("update SysOrder v set v.isDeleted = true where v.pkOrderId in ?1")
    void deleteBatch(List<Long> ids);

}
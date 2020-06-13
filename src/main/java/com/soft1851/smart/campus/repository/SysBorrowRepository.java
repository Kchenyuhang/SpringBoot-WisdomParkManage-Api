package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/3 12:58
 * @Version 1.0
 **/
public interface SysBorrowRepository extends JpaRepository<SysBorrow, Long> {
    /**
     * 查询范围内的借阅记录
     * @param startTime
     * @param endTime
     * @return
     */
    List<SysBorrow> getSysBorrowsByGmtCreateBetween(Timestamp startTime, Timestamp endTime);

    /**
     * 修改还书状态
     * @param pkBorrowId
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update first_smart_campus.sys_borrow b set b.is_deleted=?2 where b.pk_borrow_id=?1",nativeQuery = true)
    int setIsDeletedByPkBorrowId(Long pkBorrowId,Boolean isDeleted);
}

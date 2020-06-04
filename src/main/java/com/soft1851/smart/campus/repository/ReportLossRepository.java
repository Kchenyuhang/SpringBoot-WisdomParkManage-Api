package com.soft1851.smart.campus.repository;


import com.soft1851.smart.campus.model.entity.ReportLoss;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName ReportLossRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/1
 **/
public interface ReportLossRepository extends JpaRepository<ReportLoss, Long> {
    /**
     * 申请挂失
     * @param pkReportLossId
     * @param lossStatus
     * @return
     */
    @Modifying
    @LastModifiedBy
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update report_loss set loss_status = ?2 where pk_report_loss_id = ?1",nativeQuery = true)
    int updateLossStatus(Long pkReportLossId,Boolean lossStatus);
}
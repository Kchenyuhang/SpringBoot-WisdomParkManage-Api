package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tao
 */
public interface SysFeedbackRepository extends JpaRepository<SysFeedback, Long> {
    /**
     * 根据id查询反馈数据
     * @param id
     * @return
     */
    SysFeedback findSysFeedbackByPkFeedbackId(Long id);

    /**
     * 根据主键id删除反馈数据
     * @param pkFeedbackId
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query("delete from SysFeedback where pkFeedbackId = ?1")
    void deleteByPkFeedbackId(Long pkFeedbackId);

    /**
     * 批量删除
     * @param ids
     */
    @Modifying
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Query("delete from SysFeedback f where f.pkFeedbackId in (?1)")
    void deleteBatch(List<Long> ids);
}

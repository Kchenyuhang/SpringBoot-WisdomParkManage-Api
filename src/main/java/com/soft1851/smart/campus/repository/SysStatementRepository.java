package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tao
 */
public interface SysStatementRepository extends JpaRepository<SysStatement, Long> {
    /**
     * 根据id查找声明
     * @param id
     * @return
     */
    SysStatement findSysStatementByPkStatementId(Long id);

    /**
     * 根据主键id删除数据
     * @param pkStatementId
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query("delete from SysStatement where pkStatementId = ?1")
    void deleteByPkStatementId(Long pkStatementId);

    /**
     * 批量删除
     * @param ids
     */
    @Modifying
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Query("delete from SysStatement s where s.pkStatementId in (?1)")
    void deleteBatch(List<Long> ids);
}

package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.InfoManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName InfoManageRepository
 * @Description TODO
 * @Date 2020/6/1  10:21
 * @Version 1.0
 **/
public interface InfoManageRepository extends JpaRepository<InfoManage, Long> {


    /**
     * 根据id差咨询
     * @param id
     * @return
     */
    InfoManage findByPkInfoManageId(Long id);

    /**
     * 批量删除
     * @param ids
     */
    @Modifying
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Query("delete from InfoManage M where M.pkInfoManageId in (?1)")
    void deleteBatch(List<Long> ids);


}

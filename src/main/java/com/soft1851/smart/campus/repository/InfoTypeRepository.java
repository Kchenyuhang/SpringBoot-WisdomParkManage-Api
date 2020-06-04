package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.InfoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName InfoTypeRepository
 * @Description TODO
 * @Date 2020/6/2  10:10
 * @Version 1.0
 **/

public interface InfoTypeRepository extends JpaRepository<InfoType, Long> {


    /**
     * 按照降序，查询排序ID最大数据
     * @return
     */
    InfoType findTopByOrderBySortDesc();
    /**
     * 根据id差咨询
     * @param id
     * @return
     */
    InfoType findByPkInfoTypeId(Long id);

    /**
     * 批量删除
     * @param ids
     */
    @Modifying
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Query("delete from InfoType T where T.pkInfoTypeId in (?1)")
    void deleteBatch(List<Long> ids);
}

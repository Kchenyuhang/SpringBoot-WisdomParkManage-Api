package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tao
 */
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
    /**
     * 查询所有角色
     * @return
     */
    @Query("select r from SysRole r")
    List<SysRole> findAllRole();

    /**
     * 根据id查角色信息
     * @param id
     * @return
     */
    SysRole findByPkRoleId(Long id);

    /**
     * 批量删除
     * @param ids
     */
    @Modifying
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Query("delete from SysRole s where s.pkRoleId in (?1)")
    void deleteBatch(List<Long> ids);

    /**
     * 按照降序，查询排序ID最大数据
     * @return
     */
    SysRole findTopByOrderBySortDesc();


}

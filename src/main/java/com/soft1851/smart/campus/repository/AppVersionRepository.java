package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.AppVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tao
 */
public interface AppVersionRepository extends JpaRepository<AppVersion, Long> {
    /**
     * 根据id查询APP版本数据
     * @param id
     * @return
     */
    AppVersion findAppVersionByPkAppVersionId(Long id);

    /**
     * 根据主键id删除APP版本数据
     * @param pkAppVersionId
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query("delete from AppVersion where pkAppVersionId = ?1")
    void deleteByPkAppVersionId(Long pkAppVersionId);

    /**
     * 批量删除
     * @param ids
     */
    @Modifying
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Query("delete from AppVersion f where f.pkAppVersionId in (?1)")
    void deleteBatch(List<Long> ids);

    /**
     * 查找出最高版本号
     * @return
     */
    AppVersion findTopByOrderByPkAppVersionIdDesc();

    /***
     * 查找出最低版本号的数据
     * @return
     */
    AppVersion findTopByOrderByPkAppVersionIdAsc();

    /**
     * 查询所有主键id
     * @return
     */
    @Query(value = "select v.pk_app_version_id from first_smart_campus.app_version as v ",nativeQuery = true)
    List<Long> selectAllPkAppVersionId();

    /**
     * 批量修改最高版本号
     * @param maxVersion
     * @param ids
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query("update AppVersion v set v.maxVersion = ?1 where v.pkAppVersionId in ?2")
    int updateMaxVersion(String maxVersion,List<Long> ids);

    /**
     * 批量修改最低版本号
     * @param minVersion
     * @param ids
     * @return
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query("update AppVersion v set v.minVersion = ?1 where v.pkAppVersionId in ?2")
    int updateMinVersion(String minVersion,List<Long> ids);

}

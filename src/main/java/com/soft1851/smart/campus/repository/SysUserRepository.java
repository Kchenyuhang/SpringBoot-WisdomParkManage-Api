package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/19
 * @Version 1.0
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    /**
     * 根据用户手机号查询用户信息
     *
     * @param phoneNumber
     * @return
     */
    SysUser getSysUserBySysUserPhoneNumber(String phoneNumber);


    /**
     * 根据用户id查询数据信息
     * @param pkUserId
     * @return
     */
    @Query(value = "SELECT ur.sys_user_id,ur.role_id,sr.role_name,su.sys_user_name,su.sys_user_phone_number,su.is_enabled,su.gmt_create " +
            "FROM first_smart_campus.user_role ur " +
            "LEFT JOIN first_smart_campus.sys_role sr " +
            "ON ur.role_id = sr.pk_role_id " +
            "LEFT JOIN first_smart_campus.sys_user su " +
            "ON ur.sys_user_id = su.pk_user_id " +
            "WHERE su.pk_user_id=?1",nativeQuery = true)
    Map selectAdminById(String pkUserId);


    /**
     * 根据主键id删除数据
     * @param pkUserId
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query("delete from SysUser where pkUserId = ?1")
    void deleteByPkUserId(String pkUserId);

    /**
     * 根据用户id查询系统用户数据
     * @param pkUserId
     * @return
     */
    SysUser findSysUserByPkUserId(String pkUserId);
}

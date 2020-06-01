package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;


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
}

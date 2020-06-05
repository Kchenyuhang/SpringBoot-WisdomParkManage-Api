package com.soft1851.smart.campus.service.Impl;

import com.alibaba.fastjson.JSON;
import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.AdminDto;
import com.soft1851.smart.campus.model.dto.AdminUpdateDto;
import com.soft1851.smart.campus.model.entity.SysUser;
import com.soft1851.smart.campus.model.entity.UserRole;
import com.soft1851.smart.campus.repository.SysUserRepository;
import com.soft1851.smart.campus.repository.UserRoleRepository;
import com.soft1851.smart.campus.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserRoleServiceImpl
 * @Description TODO
 * @date 2020-06-01 14:59
 **/
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private UserRoleRepository userRoleRepository;

    //查询所有管理员数据信息
    @Override
    public ResponseResult selectAllAdmin() {
        List<Map> mapList = new ArrayList<Map>();
        List<SysUser> sysUsers = sysUserRepository.findAll();
        sysUsers.forEach(sysUser -> {
            Map admin = sysUserRepository.selectAdminById(sysUser.getPkUserId());
            mapList.add(admin);
        });
        return ResponseResult.success(JSON.toJSON(mapList));
    }

    @Override
    public ResponseResult increaseAdmin(AdminDto adminDto) {
        //只需要密码、用户名、手机号
        String userId = UUID.randomUUID().toString();
        System.out.println("***用户表***" + userId);
        SysUser sysUser1 = SysUser.builder()
                .pkUserId(userId)
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .isDeleted(false)
                .isEnabled(true)
                .salt("xyz")
                .sysPassword(adminDto.getSysPassword())
                .sysUserAvatar("https://niit-student.oss-cn-beijing.aliyuncs.com/markdown/20200601182918.png")
                .sysUserName(adminDto.getSysUserName())
                .sysUserPhoneNumber(adminDto.getSysUserPhoneNumber())
                .build();
        sysUserRepository.save(sysUser1);
        System.out.println("***用户角色关联表***" + userId);
        UserRole userRole = UserRole.builder()
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .isDeleted(false)
                .roleId(adminDto.getRoleId())
                .sysUserId(userId)
                .build();
        userRoleRepository.save(userRole);
        System.out.println("***插入结束***" + userId);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult deletedAdmin(String sysUserId) {
        UserRole sysUser = userRoleRepository.findUserRoleBySysUserId(sysUserId);
        //首先查询用户是否存在 若存在进行单个删除
        if (sysUser != null) {
            userRoleRepository.deleteBySysUserId(sysUserId);
            sysUserRepository.deleteByPkUserId(sysUserId);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.USER_NOT_FOUND);
        }
    }

    @Override
    public ResponseResult modificationAdmin(AdminUpdateDto adminUpdateDto) {
        SysUser sysUser = sysUserRepository.findSysUserByPkUserId(adminUpdateDto.getPkUserId());
        UserRole userRole = userRoleRepository.findUserRoleBySysUserId(adminUpdateDto.getPkUserId());
        if (sysUser != null) {
            if (adminUpdateDto.getSysUserName() != null) {
                sysUser.setSysUserName(adminUpdateDto.getSysUserName());
            }
            if (adminUpdateDto.getSysUserPhoneNumber() != null) {
                sysUser.setSysUserPhoneNumber(adminUpdateDto.getSysUserPhoneNumber());
            }
            if (adminUpdateDto.getSysUserAvatar() != null) {
                sysUser.setSysUserAvatar(adminUpdateDto.getSysUserAvatar());
            }
            if (adminUpdateDto.getIsEnabled() != null) {
                sysUser.setIsEnabled(adminUpdateDto.getIsEnabled());
            }
            sysUserRepository.saveAndFlush(sysUser);
            if (adminUpdateDto.getRoleId() != null) {
                userRole.setRoleId(adminUpdateDto.getRoleId());
                userRoleRepository.saveAndFlush(userRole);
            }
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}

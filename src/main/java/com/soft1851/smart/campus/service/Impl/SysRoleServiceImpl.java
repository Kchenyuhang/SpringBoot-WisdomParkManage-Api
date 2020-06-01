package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.entity.SysRole;
import com.soft1851.smart.campus.repository.SysRoleRepository;
import com.soft1851.smart.campus.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysRoleServiceImpl
 * @Description TODO
 * @date 2020-05-31 14:58
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleRepository sysRoleRepository;

    /**
     * 查询所有角色数据
     *
     * @return
     */
    @Override
    public ResponseResult findAllSysRole() {
        return ResponseResult.success(sysRoleRepository.findAllRole());
    }

    /**
     * 删除单个角色信息
     *
     * @param id
     * @return
     */
    @Override
    public ResponseResult deletedSysRole(Long id) {
        //根据id查询角色数据是否存在 ，若存在进行删除，不存则返回 数据有误
        SysRole sysRole = sysRoleRepository.findByPkRoleId(id);
        if (sysRole != null) {
            sysRoleRepository.deleteById(id);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 批量删除数据
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseResult deletedBatch(String ids) {
        //判断是否有数据
        if (ids.length() != 0) {
            //将接收到的ids字符串，使用逗号分割
            String[] idArr = ids.split(",");
            List<Long> idsList = new ArrayList<Long>();
            for (String id : idArr) {
                //遍历所有id存入到list
                idsList.add(Long.valueOf(id));
            }
            sysRoleRepository.deleteBatch(idsList);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.PARAM_IS_BLANK);
        }
    }

    /**
     * 修改角色信息
     * @param sysRole
     * @return
     */
    @Override
    public ResponseResult updateSysRole(SysRole sysRole) {
        //根据id查询该角色信息是否存在，不存在返回数据不存在状态码
        SysRole sysRole1 = sysRoleRepository.findByPkRoleId(sysRole.getPkRoleId());
        if (sysRole1 != null) {
            sysRole1.setRoleName(sysRole.getRoleName());
            sysRole1.setRoleDecoration(sysRole.getRoleDecoration());
            sysRole1.setIsDeleted(sysRole.getIsDeleted());
            sysRoleRepository.saveAndFlush(sysRole1);
            return ResponseResult.success(sysRole1);
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 新增
     * @param sysRole
     * @return
     */
    @Override
    public ResponseResult increaseSysRole(SysRole sysRole) {
       SysRole sysRole2 = sysRoleRepository.findTopByOrderBySortDesc();
        SysRole sysRole1 = SysRole.builder()
//                .pkRoleId()
                .roleName(sysRole.getRoleName())
                .roleDecoration(sysRole.getRoleDecoration())
                .isDeleted(false)
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .sort(sysRole2.getSort()+1)
                .build();
        sysRoleRepository.save(sysRole1);
        return ResponseResult.success();
    }
}

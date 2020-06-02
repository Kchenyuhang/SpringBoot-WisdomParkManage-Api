package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.SysRole;

/**
 * @author Tao
 */
public interface SysRoleService {
    /**
     * 查询全部角色数据
     * @return
     */
    ResponseResult findAllSysRole();

    /**
     * 单个删除角色数据
     * @param id
     * @return
     */
    ResponseResult deletedSysRole(Long id);

    /**
     * 批量删除角色数据
     * @param ids
     * @return
     */
    ResponseResult deletedBatch(String ids);

    /**
     * 修改角色数据
     * @param sysRole
     * @return
     */
    ResponseResult updateSysRole(SysRole sysRole);

    /**
     * 新增角色数据
     * @param sysRole
     * @return
     */
    ResponseResult increaseSysRole(SysRole sysRole);

    /**
     * 拖拽排序后，修改排序id
     * @param sortList
     * @return
     */
    ResponseResult updateSysRoleSort(String sortList);
}

package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.AdminDto;
import com.soft1851.smart.campus.model.dto.AdminUpdateDto;

/**
 * @author Tao
 */
public interface UserRoleService {
    /**
     * 查所有管理员
     * @return
     */
    ResponseResult selectAllAdmin();

    /**
     * 新增管理员
     * @param adminDto
     * @return
     */
    ResponseResult increaseAdmin(AdminDto adminDto);

    /**
     * 删除管理员
     * @param sysUserId
     * @return
     */
    ResponseResult deletedAdmin(String sysUserId);

    /**
     * 修改管理员数据
     * @param adminUpdateDto
     * @return
     */
    ResponseResult modificationAdmin(AdminUpdateDto adminUpdateDto);
}

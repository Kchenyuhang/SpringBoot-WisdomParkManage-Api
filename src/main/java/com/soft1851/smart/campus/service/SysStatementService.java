package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysStatement;

/**
 * @author Tao
 */
public interface SysStatementService {
    /**
     * 分页查询所有声明数据
     * @param pageDto
     * @return
     */
    ResponseResult findAllStatement(PageDto pageDto);

    /**
     * 新增声明
     * @param sysStatement
     * @return
     */
    ResponseResult increaseSysStatement(SysStatement sysStatement);

    /**
     * 修改声明数据
     * @param sysStatement
     * @return
     */
    ResponseResult modificationSysStatement(SysStatement sysStatement);

    /**
     * 删除声明数据根绝id
     * @param sysPkSysStatement
     * @return
     */
    ResponseResult deletionSysStatement(Long sysPkSysStatement);

    /**
     * 批量删除声明数据
     * @param ids
     * @return
     */
    ResponseResult deletedBatch(String ids);
}

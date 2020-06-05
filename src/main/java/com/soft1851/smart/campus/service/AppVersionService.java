package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.AppVersion;

/**
 * @author Tao
 */
public interface AppVersionService {
    /**
     * 分页查询所有App版本数据
     * @param pageDto
     * @return
     */
    ResponseResult findAllAppVersion(PageDto pageDto);

    /**
     * 新增App版本数据
     * @param appVersion
     * @return
     */
    ResponseResult increaseAppVersion(AppVersion appVersion);

    /**
     * 修改App版本数据
     * @param appVersion
     * @return
     */
    ResponseResult modificationAppVersion(AppVersion appVersion);

    /**
     * 根据id删除App版本数据
     * @param
     * @return
     */
    ResponseResult deletionAppVersion(Long id);

    /**
     * 批量删除App版本数据
     * @param ids
     * @return
     */
    ResponseResult deletedBatch(String ids);
}

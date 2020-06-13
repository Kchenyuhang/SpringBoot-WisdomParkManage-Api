package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;

/**
 * @author Tao
 */
public interface SysBookService {


    /**
     * 分页查询所有角色
     * @param pageDto
     * @return
     */
    ResponseResult findAllSysBookByPage(PageDto pageDto);

}

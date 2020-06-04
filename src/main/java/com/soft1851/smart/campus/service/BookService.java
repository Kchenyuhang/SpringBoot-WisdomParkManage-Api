package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.SysBookDto;
import com.soft1851.smart.campus.model.entity.SysBook;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/1 8:15
 * @Version 1.0
 **/
public interface BookService {
    /**
     * 添加一种图书
     *
     * @param sysBookDto
     * @return
     */
    ResponseResult increaseSysBook(SysBookDto sysBookDto);

    /**
     * 批量删除图书
     *
     * @param ids
     * @return
     */
    ResponseResult deletedBatchSysBook(String ids);

    /**
     * 发现所有图书
     * @return
     */
    ResponseResult findAllByPage(PageDto pageDto);

    /**
     * 更新图书信息
     * @param sysBookDto
     * @return
     */
    ResponseResult updatedBook(SysBookDto sysBookDto);
}
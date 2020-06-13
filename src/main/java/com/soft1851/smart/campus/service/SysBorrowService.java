package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BorrowDto;
import com.soft1851.smart.campus.model.dto.BorrowInsertDto;
import com.soft1851.smart.campus.model.dto.PageDto;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/3 12:57
 * @Version 1.0
 **/
public interface SysBorrowService {
    /**
     * 查找借书记录
     * @return
     */
    ResponseResult findAllByPage(PageDto pageDto);

    /**
     * 根据时间查找借书记录
     * @param borrowDto
     * @return
     */
    ResponseResult getBorrowByTime(BorrowDto borrowDto);

    /**
     * 添加借阅信息
     * @param borrowInsertDto
     * @return
     */
    ResponseResult borrowInsert(BorrowInsertDto borrowInsertDto);
}
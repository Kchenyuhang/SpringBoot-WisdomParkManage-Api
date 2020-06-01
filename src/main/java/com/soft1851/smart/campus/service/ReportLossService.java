package com.soft1851.smart.campus.service;


import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;

/**
 * @ClassName ReportLossService
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/1
 **/
public interface ReportLossService {
    /**
     * 分页查询挂失信息
     * @param pageDto
     * @return
     */
    ResponseResult findAllByPage(PageDto pageDto);
}
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

    /**
     * 校园卡挂失
     * @param pkReportLossId
     * @param lossStatus
     * @return
     */
    ResponseResult updateLossStatus(Long pkReportLossId,Boolean lossStatus);
    /**
     * 删除挂失信息
     * @return
     */
    ResponseResult deleteReportLoss(Long pkReportLossId);

    /**
     * 批量删除信息
     * @param ids
     * @return
     */
    ResponseResult deletedBatch(String ids);

    /**
     * 分页查询未被逻辑查询删除的挂失信息数据
     * @param pageDto
     * @return
     */
    ResponseResult getAllReportLoss(PageDto pageDto);

}
package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysFeedback;

/**
 * @author Tao
 */
public interface SysFeedbackService {
    /**
     * 分页查询所有反馈数据
     * @param pageDto
     * @return
     */
    ResponseResult findAllSysFeedback(PageDto pageDto);

    /**
     * 新增反馈
     * @param sysFeedback
     * @return
     */
    ResponseResult increaseSysFeedback(SysFeedback sysFeedback);

    /**
     * 修改反馈数据
     * @param sysFeedback
     * @return
     */
    ResponseResult modificationSysFeedback(SysFeedback sysFeedback);

    /**
     * 根据id删除反馈数据
     * @param pkFeedbackId
     * @return
     */
    ResponseResult deletionSysFeedback(Long pkFeedbackId);

    /**
     * 批量删除声明数据
     * @param ids
     * @return
     */
    ResponseResult deletedBatch(String ids);
}

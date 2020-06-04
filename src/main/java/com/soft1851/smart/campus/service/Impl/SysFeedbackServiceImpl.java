package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysFeedback;
import com.soft1851.smart.campus.repository.SysFeedbackRepository;
import com.soft1851.smart.campus.service.SysFeedbackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysFeedbackServiceImpl
 * @Description TODO
 * @date 2020-06-02 22:32
 **/
@Service
public class SysFeedbackServiceImpl implements SysFeedbackService {

    @Resource
    private SysFeedbackRepository sysFeedbackRepository;

    /**
     * 分页查询所有
     *
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult findAllSysFeedback(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkFeedbackId");
        Page<SysFeedback> feedbacks = sysFeedbackRepository.findAll(pageable);
        return ResponseResult.success(feedbacks.getContent());
    }

    @Override
    public ResponseResult increaseSysFeedback(SysFeedback sysFeedback) {
        boolean isTitle = sysFeedback.getTitle() != null;
        boolean isContent = sysFeedback.getContent() != null;
        if (isTitle && isContent) {
            SysFeedback sysFeedback1 = SysFeedback.builder()
                    .title(sysFeedback.getTitle())
                    .content(sysFeedback.getContent())
                    .contactWay(sysFeedback.getContactWay())
                    .isHandled(false)
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(false)
                    .build();
            sysFeedbackRepository.save(sysFeedback1);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.PARAM_NOT_COMPLETE);
        }
    }

    /**
     * 修改反馈接口
     *
     * @param sysFeedback
     * @return
     */
    @Override
    public ResponseResult modificationSysFeedback(SysFeedback sysFeedback) {
        SysFeedback sysFeedback1 = sysFeedbackRepository.findSysFeedbackByPkFeedbackId(sysFeedback.getPkFeedbackId());
        if (sysFeedback1 != null) {
            sysFeedback1.setTitle(sysFeedback.getTitle());
            sysFeedback1.setContent(sysFeedback.getContent());
            sysFeedback1.setIsHandled(sysFeedback.getIsHandled());
            if (sysFeedback.getContactWay() != null) {
                sysFeedback1.setContactWay(sysFeedback.getContactWay());
            }
            sysFeedbackRepository.saveAndFlush(sysFeedback1);
            return ResponseResult.success(sysFeedback1);
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 单个删除反馈
     *
     * @param pkFeedbackId
     * @return
     */
    @Override
    public ResponseResult deletionSysFeedback(Long pkFeedbackId) {
        SysFeedback sysFeedback = sysFeedbackRepository.findSysFeedbackByPkFeedbackId(pkFeedbackId);
        if (sysFeedback != null) {
            sysFeedbackRepository.deleteByPkFeedbackId(pkFeedbackId);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseResult deletedBatch(String ids) {
        //判断是否有数据
        if (ids.length() != 0) {
            //将接收到的ids字符串，使用逗号分割
            String[] idArr = ids.split(",");
            List<Long> idsList = new ArrayList<Long>();
            for (String id : idArr) {
                //遍历所有id存入到list
                idsList.add(Long.valueOf(id));
            }
            sysFeedbackRepository.deleteBatch(idsList);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.PARAM_IS_BLANK);
        }
    }
}

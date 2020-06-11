package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.ReportLoss;
import com.soft1851.smart.campus.repository.ReportLossRepository;
import com.soft1851.smart.campus.service.ReportLossService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReportServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/1
 **/
@Service
public class ReportLossServiceImpl implements ReportLossService {
    @Resource
    private ReportLossRepository reportLossRepository;

    /**
     * 分页查询所有信息
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult findAllByPage(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkReportLossId");
        Page<ReportLoss> reportLosses = reportLossRepository.findAll(pageable);
        return ResponseResult.success(reportLosses.getContent());
    }

    @Override
    public ResponseResult updateLossStatus(Long pkReportLossId, Boolean lossStatus) {
        return ResponseResult.success(reportLossRepository.updateLossStatus(pkReportLossId, lossStatus));
    }

    @Override
    public ResponseResult deleteReportLoss(Long pkReportLossId) {
        reportLossRepository.deleteBypkReportLossId(pkReportLossId);
        return ResponseResult.success();

    }

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
            reportLossRepository.deleteBatch(idsList);
            return ResponseResult.success("删除成功");
        } else {
            return ResponseResult.failure(ResultCode.PARAM_IS_BLANK);
        }
    }

    @Override
    public ResponseResult getAllReportLoss(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pk_report_loss_id");
        Page<ReportLoss> reportLosses = reportLossRepository.getAllReportLoss(pageable);
        return ResponseResult.success(reportLosses.getContent());
    }

}
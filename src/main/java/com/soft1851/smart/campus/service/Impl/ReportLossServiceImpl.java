package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
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
}
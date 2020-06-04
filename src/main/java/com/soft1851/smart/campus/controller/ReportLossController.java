package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.service.ReportLossService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName ReportLossController
 * @Description TODO
 * @Author 田震
 * @Date 2020/6/1
 **/
@Slf4j
@RestController
@Api(value = "ReportLossController",tags = {"挂失接口"})
public class ReportLossController {
    @Resource
    private ReportLossService reportLossService;
    /**
     * 分页查询所有挂失消息
     * @param pageDto
     * @return
     */
    @PostMapping("/loss/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto){
        return reportLossService.findAllByPage(pageDto);
    }

    /**
     * 申请挂失
     * @param pkReportLossId
     * @param lossStatus
     * @return
     */
    @PostMapping("/loss/statuschange")
    ResponseResult updateLossStatus(@RequestParam("pk_report_loss_id")Long pkReportLossId,
                                    @RequestParam("loss_status") Boolean lossStatus){
        return  reportLossService.updateLossStatus(pkReportLossId, lossStatus);
    }

    /**
     * 删除挂失信息
     * @param pkReportLossId
     * @return
     */
    @GetMapping("/loss/deletion/{pk_card_id}")
    ResponseResult deleteReportLoss(@RequestParam ("pk_report_loss_id") Long pkReportLossId){
        return reportLossService.deleteReportLoss(pkReportLossId);
    }

}
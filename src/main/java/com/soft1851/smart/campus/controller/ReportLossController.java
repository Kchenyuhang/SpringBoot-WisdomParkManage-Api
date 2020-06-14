package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.QueryDto;
import com.soft1851.smart.campus.service.ReportLossService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
        return reportLossService.getAllReportLoss(pageDto);
    }

    /**
     * 申请挂失
     * @param queryDto
     * @return
     */
    @PostMapping("/loss/statuschange")
    ResponseResult updateLossStatus(@RequestBody QueryDto queryDto){
        return  reportLossService.updateLossStatus(Long.parseLong(queryDto.getField().toString()),
                queryDto.getStatus());
    }

    /**
     * 删除挂失信息
     * @param queryDto
     * @return
     */
    @PostMapping("/loss/deletion/{pk_card_id}")
    ResponseResult deleteReportLoss(@RequestBody QueryDto queryDto){
        return reportLossService.deleteReportLoss(Long.parseLong(queryDto.getField().toString()));
    }
    /**
     * 批量删除挂失
     * @return List<ReportLoss>
     */
    @ApiOperation(value = "批量删除挂失信息",notes = "")
    @PostMapping(value = "/deletionBath/{ids}")
    public ResponseResult deletedBatch(@RequestBody QueryDto queryDto){
        return reportLossService.deletedBatch(queryDto.getField().toString());
    }


}
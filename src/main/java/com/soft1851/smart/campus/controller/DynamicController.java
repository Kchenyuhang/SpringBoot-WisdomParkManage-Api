package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BatchDeletionDto;
import com.soft1851.smart.campus.model.dto.DeletionDto;
import com.soft1851.smart.campus.model.dto.DynamicDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.service.DynamicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Yujie_Zhao
 * @ClassName DynamicController
 * @Description 校友圈动态
 * @Date 2020/6/13  13:28
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/dynamic")
@Api(value = "DynamicController",tags = {"校友动态接口"})
public class DynamicController {
    @Resource
    private DynamicService dynamicService;

    /**
     * 添加校友动态
     * @return
     */
    @ApiOperation(value = "添加动态",notes = "")
    @PostMapping(value = "/insert")
    public ResponseResult insertDynamic(@RequestBody DynamicDto dynamicDto){
        return dynamicService.insertDynamic(dynamicDto);
    }
    /**
     * 批量查找动态(逻辑删除)
     * @return
     */
    @ApiOperation(value = "批量查找动态",notes = "")
    @PostMapping(value = "/all")
    public ResponseResult findAllDynamic(@RequestBody PageDto pageDto){
        return dynamicService.findAllDynamic(pageDto);
    }

    /**
     * 删除单个动态(逻辑删除)
     * @return
     */
    @ApiOperation(value = "删除单个动态",notes = "")
    @PostMapping(value = "/deletion")
    public ResponseResult deleteDynamic(@RequestBody DeletionDto deletionDto){
        return dynamicService.deleteDynamic(deletionDto.getId());
    }

    /**
     * 批量删除动态
     * @return
     */
    @ApiOperation(value = "批量删除动态",notes = "入参为字符串，以逗号隔开")
    @PostMapping(value = "/deletionBath")
    public ResponseResult deletedBatch(@RequestBody BatchDeletionDto batchDeletionDto){
        return dynamicService.deletedBatch(batchDeletionDto.getIds());
    }


}
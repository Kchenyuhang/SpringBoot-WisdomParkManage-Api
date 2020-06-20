package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.QueryDto;
import com.soft1851.smart.campus.service.SysSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysSubjectController
 * @Description TODO
 * @date 2020-06-19 11:44
 **/
@RestController
@RequestMapping(value = "/subject")
@Api(value = "SysSubjectController", tags = "科目管理模块")
public class SysSubjectController {
    @Resource
    private SysSubjectService sysSubjectService;

    /**
     * 查询所有科目
     * @param queryDto
     * @return
     */
    @ApiOperation(value = "查询所有科目",notes = "关键字给filed1")
    @PostMapping(value = "/all")
    ResponseResult findAllStatement(@RequestBody QueryDto queryDto){
        return sysSubjectService.getSubjectLike(queryDto.getFiled1());
    }
}

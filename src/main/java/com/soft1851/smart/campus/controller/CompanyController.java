package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.JobPageDto;
import com.soft1851.smart.campus.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author su
 * @className CompanyController
 * @Description TODO
 * @Date 2020/6/17
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/company")
@Api(tags = "校园聘的接口")
public class CompanyController {

    @Resource
    private CompanyService companyService;


    @PostMapping("/list")
    @ApiOperation(value = "公司列表",  notes = "请求参数为JobPageDto")
    public ResponseResult typeList(@RequestBody JobPageDto jobPageDto){
        return ResponseResult.success(companyService.findAll(jobPageDto));
    }

}

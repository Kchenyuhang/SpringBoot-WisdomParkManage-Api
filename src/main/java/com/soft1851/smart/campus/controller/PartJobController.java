package com.soft1851.smart.campus.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.JobDto;
import com.soft1851.smart.campus.model.dto.JobPageDto;
import com.soft1851.smart.campus.model.dto.PartJobDto;
import com.soft1851.smart.campus.model.entity.PartJob;
import com.soft1851.smart.campus.service.PartJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author su
 * @className PartJobController
 * @Description TODO
 * @Date 2020/6/17
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/partJob")
@Api(tags = "校园聘的接口")
public class PartJobController {

    @Resource
    private PartJobService partJobService;

    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());


    @PostMapping("/list")
    @ApiOperation(value = "兼职列表",  notes = "请求参数为JobPageDto,field参数为max或gmt_create")
    public ResponseResult typeList(@RequestBody JobPageDto jobPageDto){
        return ResponseResult.success(partJobService.findList(jobPageDto));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加兼职",  notes = "请求参数为PartJobDto")
    public ResponseResult add(@RequestBody PartJobDto partJobDto){
        return ResponseResult.success(partJobService.add(partJobDto));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新兼职",  notes = "请求参数为PartJobDto")
    public ResponseResult update(@RequestBody PartJobDto partJobDto){
        UpdateWrapper<PartJob> wrapper = new UpdateWrapper<>();
        wrapper.set("name",partJobDto.getName())
                .set("description",partJobDto.getDescription())
                .set("workplace", partJobDto.getWorkplace())
                .set("working_date", partJobDto.getWorkingDate())
                .set("working_time", partJobDto.getWorkingTime())
                .set("pay", partJobDto.getPay())
                .set("pay_type", partJobDto.getPayType())
                .set("job_type", partJobDto.getJobType())
                .set("number", partJobDto.getNumber())
                .set("gmt_modified", timestamp)
                .eq("pk_part_job_id", partJobDto.getId());
        return ResponseResult.success(partJobService.update(wrapper));
    }

    @PostMapping("/remove")
    @ApiOperation(value = "删除兼职",  notes = "请求参数为PartJobDto")
    public ResponseResult deleteJob(@RequestBody JobDto jobDto){
        UpdateWrapper<PartJob> wrapper = new UpdateWrapper<>();
        wrapper.set("is_deleted", 1)
                .eq("pk_part_job_id", jobDto.getId());
        return ResponseResult.success(partJobService.update(wrapper));
    }

}

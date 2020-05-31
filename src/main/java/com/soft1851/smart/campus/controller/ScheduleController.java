package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.ScheduleDto;
import com.soft1851.smart.campus.model.entity.SysCourse;
import com.soft1851.smart.campus.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xunmi
 * @ClassName ScheduleController
 * @Description TODO
 * @Date 2020/5/30
 * @Version 1.0
 **/
@RestController
@RequestMapping("/timetable")
public class ScheduleController {

    @Resource
    private ScheduleService scheduleService;

    /**
     * 获取指定 学期、班级、周次的课表信息接口
     *
     * @param scheduleDto
     * @return
     */
    @GetMapping("/info")
    public ResponseResult getInfo(@RequestBody ScheduleDto scheduleDto) {
        return ResponseResult.success(scheduleService.getScheduleInfo(scheduleDto.getSemesterId(), scheduleDto.getClazzId(), scheduleDto.getWeek()));
    }

    /**
     * 获取课表 id 查找课表信息接口
     *
     * @param scheduleId
     * @return
     */
    @GetMapping("/{scheduleId}")
    public ResponseResult getInfoById(@PathVariable Long scheduleId) {
        return ResponseResult.success(scheduleService.getScheduleInfoById(scheduleId));
    }

    /**
     * 新增课表
     *
     * @param sysCourse
     */
    @PostMapping("/increase")
    public void increase(@RequestBody SysCourse sysCourse) {
        System.out.println(sysCourse);
        scheduleService.increase(sysCourse);
    }
}

package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.UpdateNewExaminationDto;
import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.service.ExaminationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xunmi
 * @ClassName ExaminationController
 * @Description 考务控制器
 * @Date 2020/5/31
 * @Version 1.0
 **/
@RestController
@RequestMapping("/examination")
@Api(value = "ExaminationController" ,tags = "考务管理接口")
public class ExaminationController {

    @Resource
    private ExaminationService examinationService;

    /**
     * 修改考务
     * @param updateNewExaminationDto
     */
    @ApiOperation(value = "修改考务",notes = "")
    @PostMapping("/modification")
    public void updateInfo(@RequestBody UpdateNewExaminationDto updateNewExaminationDto) {
        examinationService.updateInfo(updateNewExaminationDto);
    }

    /**
     * 新增考务
     * @param examination
     * @return
     */
    @ApiOperation(value = "新增考务",notes = "")
    @PostMapping(value = "/increase")
    public ResponseResult increaseSysFeedback(@RequestBody Examination examination){
        return examinationService.increaseInfo(examination);
    }

    /**
     * 查询所有考务
     * @return
     */
    @ApiOperation(value = "查询所有考务",notes = "")
    @PostMapping(value = "/all")
    public ResponseResult selectAllExamination(){
        return examinationService.selectAllExamination();
    }


//    /**
//     * 统计出考务数据的总量接口
//     *
//     * @return
//     */
//    @PostMapping("/count")
//    public Long totalNum() {
//        return examinationService.countNum();
//    }
}

package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.service.ExaminationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xunmi
 * @ClassName ExaminationController
 * @Description TODO
 * @Date 2020/5/31
 * @Version 1.0
 **/
@RestController
@RequestMapping("/examination")
public class ExaminationController {

    @Resource
    private ExaminationService examinationService;

    @PutMapping("/modification")
    public void updateInfo(@RequestBody Examination examination) {
        examinationService.updateInfo(examination);
    }
}

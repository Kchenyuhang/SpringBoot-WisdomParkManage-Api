package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.model.entity.SysSubject;
import com.soft1851.smart.campus.service.SysSubjectService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/21
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/subject")
public class SysSubjectController {
    @Resource
    private SysSubjectService sysSubjectService;

    @ApiOperation(value = "获取所有科目接口")
    @PostMapping(value = "/list")
    public List<SysSubject> selectAll() {
        return sysSubjectService.selectAll();
    }
}

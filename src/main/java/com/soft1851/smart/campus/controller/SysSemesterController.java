package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.model.entity.SysSemester;
import com.soft1851.smart.campus.service.SysSemesterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xunmi
 * @ClassName SysSemesterController
 * @Description 学期控制器
 * @Date 2020/6/1
 * @Version 1.0
 **/
@RestController
@RequestMapping("/semester")
public class SysSemesterController {

    @Resource
    private SysSemesterService sysSemesterService;

    @GetMapping("/all")
    public List<SysSemester> findAll() {
        return sysSemesterService.findAll();
    }
}

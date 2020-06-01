package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.model.entity.Clazz;
import com.soft1851.smart.campus.service.ClazzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xunmi
 * @ClassName ClazzController
 * @Description 班级控制器
 * @Date 2020/6/1
 * @Version 1.0
 **/
@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @Resource
    private ClazzService clazzService;

    /**
     * 查询所有班级信息的接口
     *
     * @return
     */
    @GetMapping("/all")
    public List<Clazz> findAll() {
        return clazzService.findAll();
    }
}

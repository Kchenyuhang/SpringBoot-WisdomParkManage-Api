package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.service.SysBorrowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/3 12:56
 * @Version 1.0
 **/
@RestController
@Slf4j
public class SysBorrowController {
    @Resource
    private SysBorrowService sysBorrowService;

    @PostMapping("/book/record/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto) {
        return sysBorrowService.findAllByPage(pageDto);
    }

}

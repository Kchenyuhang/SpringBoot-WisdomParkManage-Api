package com.soft1851.smart.campus.controller;

import cn.hutool.log.Log;
import com.soft1851.smart.campus.annotation.OperationLogDetail;
import com.soft1851.smart.campus.constant.OperationType;
import com.soft1851.smart.campus.constant.OperationUnit;
import com.soft1851.smart.campus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/26
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping(value = "/test")
    @OperationLogDetail(detail = "通过手机号获取用户名", level = 3, operationUtil = OperationUnit.USER, operationType = OperationType.SELECT)
    public String findUsername(@RequestParam("name") String name) {
        logger.info("测试日志");
        return userService.findUserName(name);
    }
}

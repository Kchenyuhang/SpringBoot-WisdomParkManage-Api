package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.LoginDto;
import com.soft1851.smart.campus.service.RedisService;
import com.soft1851.smart.campus.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/30
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private RedisService redisService;

    @PostMapping(value = "/login")
    public ResponseResult login(@RequestBody LoginDto loginDto) {
        System.out.println("登录信息>>>>>>>>>>>>>>>>>>>>");
        System.out.println(sysUserService.login(loginDto));
        return ResponseResult.success(sysUserService.login(loginDto));
    }

    @GetMapping("/code")
    public void getCode(@RequestParam("phoneNumber") String phoneNumber) {
        redisService.set(phoneNumber, "123");
        System.out.println(phoneNumber);
        System.out.println(redisService.getValue(phoneNumber, String.class));
    }

    @GetMapping("/menus")
    public ResponseResult getMenus(@RequestParam("phoneNumber") String phoneNumber) {
        return ResponseResult.success((sysUserService.getSysUserMenu(phoneNumber)));
    }
}

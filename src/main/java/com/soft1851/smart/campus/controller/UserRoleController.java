package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.AdminDto;
import com.soft1851.smart.campus.model.dto.AdminUpdateDto;
import com.soft1851.smart.campus.service.UserRoleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserRoleController
 * @Description TODO
 * @date 2020-06-01 16:43
 **/
@RestController
@RequestMapping(value = "/admin")
@Api(value = "UserRoleController", tags = "用户角色管理接口")
public class UserRoleController {
    @Resource
    private UserRoleService userRoleService;

    /**
     * 查询所有管理员数据
     * @return
     */
    @GetMapping(value = "/all")
    public ResponseResult selectAllAdmin() {
        return userRoleService.selectAllAdmin();
    }

    /**
     * 删除单个管理员数据（删除用户表、用户角色关联表数据）
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deletion/{id}")
    public ResponseResult deletedAdmin(@PathVariable String id){
        return userRoleService.deletedAdmin(id);
    }

    /**
     * 新增管理员（新增用户表、用户角色关联表数据）
     * @param adminDto
     * @return
     */
    @PostMapping(value = "/increase")
    public ResponseResult increaseAdmin(@RequestBody AdminDto adminDto){
        return userRoleService.increaseAdmin(adminDto);
    }


    /**
     * 修改系统用户名、密码、手机号、头像、账号状态、角色id
     * @param adminUpdateDto
     * @return
     */
    @PutMapping(value = "/modification")
    public ResponseResult modificationAdmin(@RequestBody AdminUpdateDto adminUpdateDto){
        return userRoleService.modificationAdmin(adminUpdateDto);
    }



}
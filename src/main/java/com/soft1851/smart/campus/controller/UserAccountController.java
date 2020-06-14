package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.UserAccount;
import com.soft1851.smart.campus.service.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Yujie_Zhao
 * @ClassName UserAccountController
 * @Description 用户账号管理Controller层
 * @Date 2020/6/4  10:17
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/userAccount")
@Api(value = "UserAccountController",tags = {"用户账号接口"})
public class UserAccountController {
;
    @Resource
    private UserAccountService userAccountService;

    /**
     * 分页查询所有账号
     * @return
     */
    @ApiOperation(value = "分页查询所有账号",notes = "")
    @GetMapping(value = "/all")
    public ResponseResult findInfoType(PageDto pageDto){
        return userAccountService.findAllUserAccount(pageDto);
    }


    /**
     * 删除用户账号
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户账号",notes = "")
    @DeleteMapping(value = "/deletion/{id}")
    public ResponseResult deleteInfoType(@PathVariable String id){
        return userAccountService.deleteUserAccount(id);
    }

    /**
     * 批量删除用户账号
     * @return
     */
    @ApiOperation(value = "批量删除用户账号",notes = "")
    @DeleteMapping(value = "/deletionBath/{ids}")
    public ResponseResult deletedBatch(@PathVariable String ids){
        return userAccountService.deletedBatch(ids);
    }

    /**
     * 修改资讯分类
     * @param userAccount
     * @return
     */
    @ApiOperation(value = "修改资讯分类",notes = "")
    @PutMapping(value = "/modification")
    public ResponseResult updateInfoType(@RequestBody UserAccount userAccount){
        return userAccountService.updateUserAccount(userAccount);
    }




    /**
     * 获取所有学生数据信息
     * @param pageDto
     * @return
     */
    @ApiOperation(value = "获取所有学生数据信息",notes = "")
    @PostMapping(value = "/student")
    public ResponseResult getAllStudent(@RequestBody PageDto pageDto){
        return userAccountService.getAllStudent(pageDto);
    }


    /**
     * 获取所有教师数据信息
     * @param pageDto
     * @return
     */
    @ApiOperation(value = "获取所有教师数据信息",notes = "")
    @PostMapping(value = "/teacher")
    public ResponseResult getAllTeacher(@RequestBody PageDto pageDto){
        return userAccountService.getAllTeacher(pageDto);
    }


    /**
     * 新增用户数据信息
     * @param userAccount
     * @return
     */
    @ApiOperation(value = "新增学生数据信息",notes = "")
    @PostMapping(value = "/insert")
    public ResponseResult insertUserAccount(@RequestBody UserAccount userAccount){
        return userAccountService.insertUserAccount(userAccount);
    }


}

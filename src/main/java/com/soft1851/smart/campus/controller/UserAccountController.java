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
import java.util.List;

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
     * 添加用户账号
     * @param userAccount
     * @return
     */
    @ApiOperation(value = "添加用户账号",notes = "")
    @PostMapping(value = "/insert")
    public ResponseResult insertInfoType(@RequestBody UserAccount userAccount){
        return userAccountService.insertUserAccount(userAccount);
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

    @ApiOperation(value = "获取教师信息", notes = "")
    @GetMapping(value = "/teacher")
    public List<UserAccount> getTeacherInfoByRole() {
        return userAccountService.getTeacherInfo();
    }

    @ApiOperation(value = "获取学生信息", notes = "")
    @GetMapping(value = "/student")
    public List<UserAccount> getStudentInfoByRole() {
        return userAccountService.getStudentInfo();
    }

}

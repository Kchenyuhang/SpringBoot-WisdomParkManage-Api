package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BatchDeletionDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.QueryDto;
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
    @PostMapping(value = "/all")
    public ResponseResult findInfoType(PageDto pageDto){
        return userAccountService.findAllUserAccount(pageDto);
    }


    /**
     * 删除用户账号
     * @param
     * @return
     */
    @ApiOperation(value = "删除用户账号",notes = "")
    @PostMapping(value = "/deletion")
    public ResponseResult deleteInfoType(@RequestBody QueryDto queryDto){
        return userAccountService.deleteUserAccount(queryDto.getField().toString());
    }

    /**
     * 批量删除用户账号
     * @return
     */
    @ApiOperation(value = "批量删除用户账号",notes = "")
    @PostMapping(value = "/deletionBath")
    public ResponseResult deletedBatch(@RequestBody BatchDeletionDto batchDeletionDto){
        return userAccountService.deletedBatch(batchDeletionDto.getIds());
    }

    /**
     * 修改用户信息
     * @param userAccount
     * @return
     */
    @ApiOperation(value = "修改用户信息",notes = "")
    @PostMapping(value = "/modification")
    public ResponseResult updateInfoType(@RequestBody UserAccount userAccount){
        System.out.println(userAccount);
        int n = userAccountService.updateUserAccountById(userAccount);
        return ResponseResult.success();
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
     * 获取所有教师数据信息
     * @return
     */
    @ApiOperation(value = "获取教师分配班主任",notes = "")
    @PostMapping(value = "/headmaster")
    public ResponseResult getAllTeacherMessage(){
        return userAccountService.getAllTeacherMessage();
    }


    /**
     * 新增用户数据信息
     * @param userAccount
     * @return
     */
    @ApiOperation(value = "新增学生数据信息",notes = "")
    @PostMapping(value = "/insert")
    public ResponseResult insertUserAccount(@RequestBody UserAccount userAccount){
        System.out.println(userAccount);
        return userAccountService.insertUserAccount(userAccount);
    }

    @ApiOperation(value = "修改学生状态接口")
    @PostMapping(value = "/status")
    public ResponseResult updateUserAccountStatusById(@RequestBody UserAccount userAccount) {
        int n = userAccountService.updateStatusById(userAccount);
        return ResponseResult.success();
    }

    /**
     * 查询未被分配的学生
     * @param pageDto
     * @return
     */
    @ApiOperation(value = "查询未被分配的学生",notes = "")
    @PostMapping(value = "/undistributed")
    public ResponseResult getAllUndistributedStudents(@RequestBody PageDto pageDto){
        return userAccountService.getAllUndistributedStudent(pageDto);
    }

    /**
     * 模糊查询学生数据
     * @param batchDeletionDto
     * @return
     */
    @ApiOperation(value = "模糊查询学生数据",notes = "ids为keywords关键字")
    @PostMapping(value = "/student/like")
    public ResponseResult findStudentLike(@RequestBody BatchDeletionDto batchDeletionDto){
        return userAccountService.findStudentLike(batchDeletionDto.getIds());
    }
}

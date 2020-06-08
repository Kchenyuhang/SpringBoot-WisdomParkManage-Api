package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.UserAccount;

import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName UserAccountService
 * @Description 账号Service
 * @Date 2020/6/3  16:47
 * @Version 1.0
 **/
public interface UserAccountService {

    /**
     * 单个添加
     * @param userAccount
     * @return
     */
    ResponseResult insertUserAccount(UserAccount userAccount);

    /**
     * 查询所有账号
     * @return
     */
    ResponseResult findAllUserAccount(PageDto pageDto);


    /**
     * 单个删除账号
     * @param id
     * @return
     */
    ResponseResult deleteUserAccount(String id);

    /**
     * 批量删除账号
     * @param ids
     * @return
     */
    ResponseResult deletedBatch(String ids);

    /**
     * 修改账号
     * @param UserAccount
     * @return
     */
    ResponseResult updateUserAccount(UserAccount UserAccount);

    /**
     * 获取学生信息
     * @return
     */
    List<UserAccount> getStudentInfo();

    /**
     * 获取教师信息
     * @return
     */
    List<UserAccount> getTeacherInfo();
}

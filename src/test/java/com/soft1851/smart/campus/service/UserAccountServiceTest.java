package com.soft1851.smart.campus.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/17
 * @Version 1.0
 */
@SpringBootTest
class UserAccountServiceTest {
    @Resource
    private UserAccountService userAccountService;

    @Test
    void updateUserAccountById() {
        UserAccount userAccount = UserAccount.builder()
                .pkUserAccountId(String.valueOf(25))
                .nickname("曹")
                .gender("男")
                .jobNumber("1802333101")
                .phoneNumber("15852564869")
                .userName("曹暝桕")
                .role("学生")
                .avatar("http")
                .cardNumber(" ")
                .build();
        UpdateWrapper<UserAccount> wrapper = new UpdateWrapper<>();
        wrapper.eq("pk_user_account_id", 1);
        System.out.println(userAccountService.updateUserAccountById(userAccount));
    }
    @Test
    void findStudentLike() {
        ResponseResult responseResult = userAccountService.findStudentLike("曹");
        System.out.println(responseResult);
    }
}
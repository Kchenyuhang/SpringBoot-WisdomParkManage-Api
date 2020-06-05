package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.UserAccount;
import com.soft1851.smart.campus.repository.UserAccountRepository;
import com.soft1851.smart.campus.service.UserAccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName UserAccountServiceImpl
 * @Description 用户账号Service实现层
 * @Date 2020/6/3  16:47
 * @Version 1.0
 **/
@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Resource
    private UserAccountRepository userAccountRepository;

    /**
     * 添加账号
     * @param userAccount
     * @return
     */
    @Override
    public ResponseResult insertUserAccount(UserAccount userAccount) {
        userAccountRepository.save(userAccount);
        if (userAccount.getPkUserAccountId()!=null){
            return ResponseResult.success("添加成功");
        }
        else {
            return ResponseResult.success(ResultCode.DATABASE_ERROR);
        }

    }

    /**
     * 分页查找账号
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult findAllUserAccount(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkUserAccountId");
        Page<UserAccount> userAccountList = userAccountRepository.findAll(pageable);
        return ResponseResult.success(userAccountList);
    }

    /**
     * 单个删除账号
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteUserAccount(String id) {
        UserAccount userAccount = userAccountRepository.findByPkUserAccountId(id);
        if (userAccount!= null){
            return ResponseResult.success("删除成功");
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 批量删除账号
     * @param ids
     * @return
     */
    @Override
    public ResponseResult deletedBatch(String ids) {
        //判断是否有数据
        if (ids.length() != 0) {
            //将接收到的ids字符串，使用逗号分割
            String[] idArr = ids.split(",");
            List<Long> idsList = new ArrayList<Long>();
            for (String id : idArr) {
                //遍历所有id存入到list
                idsList.add(Long.valueOf(id));
            }
            userAccountRepository.deleteBatch(idsList);
            return ResponseResult.success("删除成功");
        } else {
            return ResponseResult.failure(ResultCode.PARAM_IS_BLANK);
        }
    }

    /**
     * 修改账号
     * @param userAccount
     * @return
     */
    @Override
    public ResponseResult updateUserAccount(UserAccount userAccount) {
        UserAccount userAccount1 = userAccountRepository.findByPkUserAccountId(userAccount.getPkUserAccountId());
        if (userAccount1!= null){
            userAccount1.setUserAccount(userAccount.getUserAccount());
            userAccount1.setUserName(userAccount.getUserName());
            userAccount1.setNickname(userAccount.getNickname());
            userAccount1.setJobNumber(userAccount.getJobNumber());
            userAccount1.setAvatar(userAccount.getAvatar());
            userAccount1.setRole(userAccount.getRole());
            userAccount1.setPhoneNumber(userAccount.getPhoneNumber());
            userAccount1.setStatus(userAccount.getStatus());
            userAccount1.setClazzId(userAccount.getClazzId());
            userAccount1.setCardNumber(userAccount.getCardNumber());
            userAccount1.setIsDeleted(userAccount.getIsDeleted());
            userAccount1.setPassword(userAccount.getPassword());
            userAccount1.setAddress(userAccount.getAddress());
            userAccount1.setGender(userAccount.getGender());
            userAccountRepository.saveAndFlush(userAccount1);
            return ResponseResult.success("修改成功");
        }
        return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public List<UserAccount> getStudentInfo() {
        return userAccountRepository.getStudentInfo("学生");
    }

    @Override
    public List<UserAccount> getTeacherInfo() {
        return userAccountRepository.getStudentInfo("教师");
    }
}

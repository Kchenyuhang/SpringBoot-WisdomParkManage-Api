package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.exception.CustomException;
import com.soft1851.smart.campus.mapper.UserAccountMapper;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysCard;
import com.soft1851.smart.campus.model.entity.UserAccount;
import com.soft1851.smart.campus.model.vo.StudentVo;
import com.soft1851.smart.campus.model.vo.TeacherVo;
import com.soft1851.smart.campus.model.vo.UserAccountVo;
import com.soft1851.smart.campus.repository.CardRepository;
import com.soft1851.smart.campus.repository.UserAccountRepository;
import com.soft1851.smart.campus.service.UserAccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

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

    @Resource
    private CardRepository cardRepository;

    @Resource
    private UserAccountMapper userAccountMapper;


    /**
     * 添加账号
     * 需要参数：学号、地址、班级id、性别、手机号、姓名、角色
     *
     * @param userAccount
     * @return
     */
    @Override
    public ResponseResult insertUserAccount(UserAccount userAccount) {

        System.out.println("***************" + userAccount.getAddress());
        //查询用户是否还存在
        UserAccount selectUserAccount = userAccountMapper.getUserAccountByJobNumber(userAccount.getJobNumber());
        //查询一卡通数据是否存在
        SysCard selectSysCard = cardRepository.getSysCardByJobNumber(userAccount.getJobNumber());

        //首先查询需要新增的用户是否已经存在,如果逻辑删除，符合条件可以重新添加数据
        if (selectUserAccount == null) {
            if (selectSysCard == null) {
                String pkUserAccountId = UUID.randomUUID().toString();
                //新增一个学生同时新增一卡通数据
                SysCard sysCard = SysCard.builder()
                        .cardBalance(Double.valueOf(0))
                        .cardNumber(userAccount.getJobNumber())
                        .cardPassword("123456")
                        .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                        .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                        .isDeleted(false)
                        .jobNumber(userAccount.getJobNumber())
                        .status(false)
                        .build();
                cardRepository.save(sysCard);

                //新增学生数据
                UserAccount userAccount1 = UserAccount.builder()
                        .pkUserAccountId(pkUserAccountId)
                        .avatar("https://niit-student.oss-cn-beijing.aliyuncs.com/markdown/20200601182918.png")
                        .cardNumber(userAccount.getJobNumber())
                        .gender(userAccount.getGender())
                        .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                        .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                        .isDeleted(false)
                        .jobNumber(userAccount.getJobNumber())
                        .nickname("用户" + userAccount.getJobNumber())
                        .password("123456")
                        .phoneNumber(userAccount.getPhoneNumber())
                        .role(userAccount.getRole())
                        .status(false)
                        .brithday(Date.valueOf("2020-06-12"))
                        .userAccount(userAccount.getJobNumber())
                        .userName(userAccount.getUserName())
                        .build();
                System.out.println(userAccount1);
                userAccountRepository.save(userAccount1);
                return ResponseResult.success();
            } else {
                return ResponseResult.failure(ResultCode.DATA_ALREADY_EXISTED);
            }
        } else {
            //返回数据已存在
            return ResponseResult.failure(ResultCode.DATA_ALREADY_EXISTED);
        }
    }

    /**
     * 分页查找账号
     *
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
        return ResponseResult.success(userAccountList.getContent());
    }

    /**
     * 单个删除账号
     *
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteUserAccount(String id) {
        UserAccount userAccount = userAccountRepository.findByPkUserAccountId(id);
        if (userAccount != null) {
            return ResponseResult.success("删除成功");
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 批量删除账号
     *
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
     *
     * @param userAccount
     * @return
     */
    @Override
    public ResponseResult updateUserAccount(UserAccount userAccount) {
        UserAccount userAccount1 = userAccountRepository.findByPkUserAccountId(userAccount.getPkUserAccountId());
        if (userAccount1 != null) {
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

    /**
     * 获取所有学生数据
     *
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult getAllStudent(PageDto pageDto) {
        List<UserAccountVo> userAccountVos = userAccountMapper.getUserAccountVo(pageDto);
        return ResponseResult.success(userAccountVos);
    }

    /**
     * 获取所有教师数据
     *
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult getAllTeacher(PageDto pageDto) {
        List<UserAccountVo> userAccountVos = userAccountMapper.getTeacherUserAccountVo(pageDto);
        return ResponseResult.success(userAccountVos);
    }

    @Override
    public int updateUserAccountById(UserAccount userAccount) {
        int n = userAccountRepository.updateUserAccountById(userAccount);
        return n;
    }

    @Override
    public int updateStatusById(UserAccount userAccount) {
        int result = userAccountRepository.updateStatusById(userAccount);
        if (result > 0) {
            return result;
        }
        throw new CustomException("修改账户状态异常", ResultCode.DATA_UPDATE_ERROR);
    }
    /**
     * 获取所有教师数据(用户班级选择班主任)
     *
     * @return
     */
    @Override
    public ResponseResult getAllTeacherMessage(){
        List<TeacherVo> teacherVos = userAccountMapper.getAllTeacher();
        return ResponseResult.success(teacherVos);
    }

    /**
     * 查询未被分配的学生
     *
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult getAllUndistributedStudent(PageDto pageDto) {
        List<StudentVo> studentVos = userAccountMapper.getAllUndistributedStudents(pageDto);
        return ResponseResult.success(studentVos);
    }

    @Override
    public ResponseResult findStudentLike(String keywords) {
        List<StudentVo> studentVos = null;
        try {
            studentVos = userAccountMapper.findStudentLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseResult.success(studentVos);
    }


}

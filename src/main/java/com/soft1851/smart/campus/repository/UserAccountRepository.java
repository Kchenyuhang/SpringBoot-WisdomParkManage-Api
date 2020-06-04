package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xunmi
 * @ClassName UserAccountRepository
<<<<<<< HEAD
 * @Description 用户账号
=======
 * @Description 用户相关操作的类
>>>>>>> 8ddd97f909f4ead9a33fba925bfc9c012bedcea3
 * @Date 2020/5/29
 * @Version 1.0
 **/
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {

    /**
     * 通过教工号查找出教师名称
     *
     * @param jobNumber
     * @return
     */
    @Query(value = "SELECT user_name FROM user_account WHERE job_number = ?1", nativeQuery = true)
    String getUserName(String jobNumber);

    /**
     * 根据id差咨询
     * @param id
     * @return
     */
    UserAccount findByPkUserAccountId(String id);

    /**
     * 批量删除
     * @param ids
     */
    @Modifying
    @Transactional(timeout = 10,rollbackFor = RuntimeException.class)
    @Query("delete from UserAccount A where A.pkUserAccountId in (?1)")
    void deleteBatch(List<Long> ids);

}

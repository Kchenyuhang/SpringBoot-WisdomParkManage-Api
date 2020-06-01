package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysCourse;
import com.soft1851.smart.campus.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author xunmi
 * @ClassName UserAccountRepository
 * @Description TODO
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
}

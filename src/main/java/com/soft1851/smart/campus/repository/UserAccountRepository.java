package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author xunmi
 * @ClassName UserAccountRepository
 * @Description 用户账号
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
     * 根据id查用户数据
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



    /**
     * 根据手机号码查询用户数据
     *
     * @param cardNumber String
     * @return Optional<UserAccount>
     */
    @Query(value = "select * from user_account as ua where ua.card_number=?1 ", nativeQuery = true)
    Optional<UserAccount> findByCardNumber(String cardNumber);

    /**
     * 根据卡号查找用户
     * @param cardNumber
     * @return
     */
    UserAccount findUserAccountByCardNumber(String cardNumber);
}

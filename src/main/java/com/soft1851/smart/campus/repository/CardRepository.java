package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysCard;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CardRepository
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/26
 **/
public interface CardRepository extends JpaRepository<SysCard, Long> {
    /**
     * 自定义分页查询
     *
     * @param pageable
     * @return
     */
    @Query("select u from SysCard u")
    Page<SysCard> findALL(Pageable pageable);

    /**
     * 根据Id查询一卡通信息
     * @param id
     * @return
     */
    SysCard findByPkCardId(Long id);

    /**
     * 根据id删除一卡通信息
     * @param pkCardId
     * @return
     */
    @Transactional
    @Modifying
    @Query("delete from SysCard where pk_card_id = ?1")
    void deleteByPkCardId(Long pkCardId);

    /**
     * 根据卡号查询一卡通信息
     * @param cardNumber
     * @return
     */
    SysCard findByCardNumber(String cardNumber);
    /**
     * 状态激活
     * @param pkCardId
     * @param Status
     * @return
     */
    @Modifying
    @LastModifiedBy
    @Transactional(rollbackFor = RuntimeException.class)
    @Query(value = "update sys_card set status = ?2 where pk_card_id = ?1",nativeQuery = true)
    int updateStatus(Long pkCardId,Boolean Status);



}
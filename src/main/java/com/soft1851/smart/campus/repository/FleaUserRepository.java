package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.FleaUser;
import com.soft1851.smart.campus.model.vo.FleaOrderVo;
import com.soft1851.smart.campus.model.vo.GoodsVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaUserRepository.java
 * @Description TODO
 * @createTime 2020年06月09日 13:54:00
 */
public interface FleaUserRepository extends JpaRepository<FleaUser, Long> {

    /**
     * 根据用户id查询该用户发布的商品
     *
     * @param userId   Long
     * @param pageable Pageable
     * @return List<GoodsVo>
     */
    @Query(value = "select new com.soft1851.smart.campus.model.vo.GoodsVo(g.goodsName,g.goodsPrice,g.goodsDescription," +
            "g.goodsMark,g.goodsImgUrl,g.goodsCreateTime,t.typeName,u.nickname) " +
            "from FleaGoods g " +
            "left join g.fleaUser u " +
            "left join g.fleaType t " +
            "where u.pkFleaUserId = ?1 ")
    Page<GoodsVo> selectGoodsByUserId(Long userId, Pageable pageable);

    /**
     * 根据用户id查询该用户的商品订单
     *
     * @param userId   Long
     * @param pageable Pageable
     * @return List<FleaOrderVo>
     */
    @Query(value = "select new com.soft1851.smart.campus.model.vo.FleaOrderVo(o.pkFleaOrderId,g.goodsName,g.goodsPrice," +
            "s.nickname,b.nickname,o.createTime,g.goodsDescription,g.goodsMark) " +
            "from FleaOrder o " +
            "left join o.fleaGoods g " +
            "left join o.fleaUserBuyer b " +
            "left join o.fleaUserSeller s " +
            "where b.pkFleaUserId = ?1 ")
    Page<FleaOrderVo> selectOrOrdersByUserId(Long userId, Pageable pageable);

    /**
     * 根据学号查询用户
     *
     * @param jobNum String
     * @return List<FleaUser>
     */
    FleaUser findAllByJobNumber(String jobNum);
}


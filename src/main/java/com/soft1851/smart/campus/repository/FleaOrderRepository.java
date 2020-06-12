
package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.FleaOrderDto;
import com.soft1851.smart.campus.model.entity.FleaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaOrderRepository.java
 * @Description TODO
 * @createTime 2020年06月09日 13:53:00
 */
public interface FleaOrderRepository extends JpaRepository<FleaOrder, String> {

    @Modifying
    @Transactional
    @Query("update FleaOrder set isDeleted = 1 where fleaGoods.pkFleaGoodsId =:#{#fleaOrderDto.getFleaGoodsPkFleaGoodsId()} and fleaUserBuyer.pkFleaUserId =:#{#fleaOrderDto.getFleaUserBuyerPkFleaUserId()}")
    int logicalDel(@Param("fleaOrderDto") FleaOrderDto fleaOrderDto);
}

package com.soft1851.smart.campus.errends.repository;

import com.soft1851.smart.campus.errends.domain.entity.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wl
 * @ClassNameDeliveryOderRepository
 * @Description TODO
 * @Date 2020/6/9
 * @Version 1.0
 */
public interface DeliveryOderRepository extends JpaRepository<DeliveryOrder,String> {
}

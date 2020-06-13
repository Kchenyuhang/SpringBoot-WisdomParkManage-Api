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
}


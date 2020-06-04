package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysBorrow;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/3 12:58
 * @Version 1.0
 **/
public interface SysBorrowRepository extends JpaRepository<SysBorrow, Long> {
    List<SysBorrow> getSysBorrowsByGmtModifiedBetween(Timestamp startTime, Timestamp endTime);
}

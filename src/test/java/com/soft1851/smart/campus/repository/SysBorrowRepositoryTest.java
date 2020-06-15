package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysBorrow;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
class SysBorrowRepositoryTest {

    @Resource
    private SysBorrowRepository sysBorrowRepository;

    @Test
    void getSysBorrowsByGmtModifiedBetween() {
        String startTime = "2020-06-01 07:48:10";
        Timestamp timestamp = Timestamp.valueOf(startTime);
        String endTime = "2020-06-04 05:50:10";
        Timestamp timestamp1 = Timestamp.valueOf(endTime);
        List<SysBorrow> list = sysBorrowRepository.getSysBorrowsByGmtCreateBetween(timestamp, timestamp1);
        System.out.println(list);
    }

    @Test
    void setIsDeletedByPkBorrowId() {
        sysBorrowRepository.setIsDeletedByPkBorrowId((long)2,false);
    }


}
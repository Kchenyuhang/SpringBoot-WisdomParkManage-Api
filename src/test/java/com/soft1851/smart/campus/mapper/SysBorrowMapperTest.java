package com.soft1851.smart.campus.mapper;

import com.soft1851.smart.campus.model.dto.TimeBorrowPageDto;
import com.soft1851.smart.campus.model.entity.SysBorrow;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
class SysBorrowMapperTest {

    @Resource
    private SysBorrowMapper sysBorrowMapper;

    @Test
    void getSysBorrowsByTime() throws SQLException {
        String startTime = "2020-06-01 07:48:10";
        Timestamp timestamp = Timestamp.valueOf(startTime);
        String endTime = "2020-06-04 04:48:10";
        Timestamp timestamp1 = Timestamp.valueOf(endTime);
//        TimeBorrowPageDto timeBorrowPageDto = TimeBorrowPageDto.builder()
//                .startTime(timestamp)
//                .endTime(timestamp1)
//                .pageSize(2)
//                .currentPage(1)
//                .build();
        List<SysBorrow> sysBorrows = sysBorrowMapper.getSysBorrowsByTime(timestamp,timestamp1,1,2);
        System.out.println(sysBorrows);
    }
}
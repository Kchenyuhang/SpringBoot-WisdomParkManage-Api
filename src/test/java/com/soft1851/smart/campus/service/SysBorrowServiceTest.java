package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BorrowDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.TimeBorrowPageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;

@SpringBootTest
class SysBorrowServiceTest {


    @Resource
    private SysBorrowService sysBorrowService;

    @Test
    void findAllByPage() {
        PageDto pageDto = PageDto.builder()
                .currentPage(0)
                .pageSize(5)
                .build();
        ResponseResult responseResult = sysBorrowService.findAllByPage(pageDto);
        System.out.println(responseResult);
    }

    @Test
    void getBorrowByTime() {
        BorrowDto borrowDto = BorrowDto.builder()
                .startTime("2020-06-01 06:48:10")
                .endTime("2020-06-04 05:48:55")
                .currentPage(1)
                .pageSize(2)
                .build();
        ResponseResult responseResult = sysBorrowService.getBorrowByTime(borrowDto);
        System.out.println(responseResult);
    }

    @Test
    void deletedSysRole() {
        ResponseResult responseResult = sysBorrowService.deletedSysRole((long)1,false);
        System.out.println(responseResult);
    }

    @Test
    void getSysBorrowsByTime() {
        String startTime = "2020-06-01 07:48:10";

        String endTime = "2020-06-04 05:50:10";

        TimeBorrowPageDto timeBorrowPageDto = TimeBorrowPageDto.builder()
                .currentPage(1)
                .pageSize(2)
                .time(startTime)
                .build();
        ResponseResult responseResult = sysBorrowService.getSysBorrowsByTime(timeBorrowPageDto);
        System.out.println(responseResult);
    }
}


package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.ReportLoss;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ReportLossServiceTest {

    @Resource
    private ReportLossService reportLossService;
    @Test
    void insertReportLoss() {
        ReportLoss reportLoss = ReportLoss.builder()
                .lossJobNumber("1802333101")
                .password("123456")
                .remark("我的卡丢了(┬＿┬)！")
                .build();
        ResponseResult responseResult = reportLossService.insertReportLoss(reportLoss);
        System.out.println(responseResult);
    }
}
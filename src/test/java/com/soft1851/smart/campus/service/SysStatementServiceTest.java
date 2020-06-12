package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysStatement;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
class SysStatementServiceTest {
    @Resource
    private SysStatementService sysStatementService;

    @Test
    void findAllStatement() {
        PageDto pageDto = PageDto.builder()
                .currentPage(0)
                .pageSize(3)
                .build();
        ResponseResult responseResult = sysStatementService.findAllStatement(pageDto);
        System.out.println(responseResult);
    }


    @Test
    void increaseSysStatement() {
        SysStatement sysStatement = SysStatement.builder()
                .statementTitle("111")
                .statementType("111")
                .statementContent("999")
                .build();
        ResponseResult responseResult = sysStatementService.increaseSysStatement(sysStatement);
        System.out.println(responseResult);
    }

    @Test
    void deletedBatch() {
        ResponseResult responseResult = sysStatementService.deletedBatch("45,46,47");
        System.out.println(responseResult);
    }
}
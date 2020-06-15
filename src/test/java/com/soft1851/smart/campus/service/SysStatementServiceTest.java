package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysStatementServiceTest {

    @Resource
    private SysStatementService sysStatementService;
    @Test
    void findAllStatement() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(3)
                .build();
        ResponseResult responseResult = sysStatementService.findAllStatement(pageDto);
        System.out.println(responseResult);
    }
}
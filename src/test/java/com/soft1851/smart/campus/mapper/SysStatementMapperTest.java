package com.soft1851.smart.campus.mapper;

import com.soft1851.smart.campus.model.entity.SysStatement;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysStatementMapperTest {

    @Resource
    private SysStatementMapper sysStatementMapper;
    @Test
    void getSysStatementByTime() throws SQLException {
        String startTime = "2020-06-14 00:52:34";
        String endTime = "2020-06-18 00:52:34";
        Timestamp timestamp = Timestamp.valueOf(startTime);
        Timestamp timestamp1 = Timestamp.valueOf(endTime);
        List<SysStatement> sysStatements = sysStatementMapper.getSysStatementByTime(timestamp,timestamp1,2,3);
        System.out.println(sysStatements);
    }
}
package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysStatement;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class SysStatementRepositoryTest {
    @Resource
    private SysStatementRepository sysStatementRepository;

    @Test
    void name() {
        List<SysStatement> sysStatements = new ArrayList<>();
        for (int i=1 ;i<50 ;i++){
            SysStatement sysStatement = SysStatement.builder()
                    .statementType("类型为"+i)
                    .statementTitle("标题"+i)
                    .statementContent("内容"+i)
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(false)
                    .build();
            sysStatements.add(sysStatement);
        }
        sysStatementRepository.saveAll(sysStatements);
    }

    @Test
    void findSysStatementByPkStatementId() {
        SysStatement sysStatement = sysStatementRepository.findSysStatementByPkStatementId((long)50);
        System.out.println(sysStatement);
    }
}
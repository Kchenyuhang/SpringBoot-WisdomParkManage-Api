package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.UpdateSysStatementDto;
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
        for (int i = 1; i < 50; i++) {
            SysStatement sysStatement = SysStatement.builder()
                    .statementType("类型为" + i)
                    .statementTitle("标题" + i)
                    .statementContent("内容" + i)
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
        SysStatement sysStatement = sysStatementRepository.findSysStatementByPkStatementId((long) 50);
        System.out.println(sysStatement);
    }

    @Test
    void updateSysStatement() {
        UpdateSysStatementDto updateSysStatementDto = UpdateSysStatementDto.builder()
                .pkStatementId((long) 1)
                .statementTitle("A级标题")
                .statementType("A级分类")
                .statementContent("A级声明内容")
                .build();
        sysStatementRepository.updateSysStatement(updateSysStatementDto);
    }

    @Test
    void deleteBatchByPkStatementId() {
        List<Long> longList = new ArrayList<>();
        longList.add((long) 1);
        longList.add((long) 2);
        longList.add((long) 4);
        longList.add((long) 5);
        longList.add((long) 6);
        sysStatementRepository.deleteBatchByPkStatementId(longList);

    }
}
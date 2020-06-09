package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.model.vo.ExaminationVo;
import com.soft1851.smart.campus.utils.DataTypeChange;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExaminationRepositoryTest {

    @Resource
    private ExaminationRepository examinationRepository;

    @Test
    void updateInfo() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Examination examination = Examination.builder()
                .pkExaminationId(1L)
                .area("测试修改操作")
                .clazzId(1L)
                .gmtCreate(timestamp)
                .gmtModified(timestamp)
                .isDeleted(false)
                .score(100)
                .semester("2019-2020 第一学期")
                .testPeriod("2020-05-09 05:56:20~2020-05-09 06:56:20")
                .subjectId(1L)
                .teacherName("张老师")
                .type("选修课")
                .build();
        examinationRepository.updateInfo(examination);
    }

    @Test
    void selectAll() {
        PageDto pageDto = PageDto.builder()
                .pageSize(10)
                .currentPage(0)
                .build();
        // 将得到一个 List<Object> 对象
        List<Object> examinationVos = examinationRepository.selectAll(pageDto);
        // 调用工具类处理 List<Object> 对象
        DataTypeChange.changeObj(examinationVos, ExaminationVo.class).forEach(System.out::println);
    }
}
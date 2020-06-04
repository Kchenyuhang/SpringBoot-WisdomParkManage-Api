package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.model.vo.ExaminationVo;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

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
                .startTime(timestamp)
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
        // 将得到一个 List<Object> 对象，后续需要进行转换
        List<Object> examinationVos = examinationRepository.selectAll(pageDto);
        for (Object obj : examinationVos) {
            Object[] rowArray = (Object[]) obj;
            Timestamp startTime = new Timestamp(((Timestamp)rowArray[7]).getTime());
            System.out.println(startTime);
            ExaminationVo build1 = ExaminationVo.builder()
                    .startTime(startTime)
                    .build();
            System.out.println(build1);
        }
    }
}
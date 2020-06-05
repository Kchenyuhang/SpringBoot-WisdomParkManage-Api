package com.soft1851.smart.campus.utils;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.vo.ExaminationVo;
import com.soft1851.smart.campus.repository.ExaminationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DataTypeChangeTest {

    @Resource
    private ExaminationRepository examinationRepository;



    @Test
    void changeObj() {
        PageDto pageDto = PageDto.builder()
                .pageSize(10)
                .currentPage(1)
                .build();
        DataTypeChange.changeObj(examinationRepository.selectAll(pageDto), ExaminationVo.class);
    }
}
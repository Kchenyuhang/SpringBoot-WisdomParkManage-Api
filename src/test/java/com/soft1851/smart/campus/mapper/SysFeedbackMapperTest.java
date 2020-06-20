package com.soft1851.smart.campus.mapper;

import com.soft1851.smart.campus.model.entity.SysFeedback;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysFeedbackMapperTest {

    @Resource
    private SysFeedbackMapper sysFeedbackMapper;

    @Test
    void name() {
        List<SysFeedback> sysFeedbacks = sysFeedbackMapper.selectList(null);
        System.out.println(sysFeedbacks.size());
    }
}
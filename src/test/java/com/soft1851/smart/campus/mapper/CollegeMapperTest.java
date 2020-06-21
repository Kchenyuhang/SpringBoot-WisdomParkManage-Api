package com.soft1851.smart.campus.mapper;

import com.soft1851.smart.campus.model.vo.CollegeVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CollegeMapperTest {

    @Resource
    private CollegeMapper collegeMapper;
    @Test
    void getAllCollege() {
        List<CollegeVo> collegeVos = collegeMapper.getAllCollege();
        System.out.println(collegeVos);
    }
}
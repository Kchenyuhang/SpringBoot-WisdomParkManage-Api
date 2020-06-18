package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.mapper.CollegeMapper;
import com.soft1851.smart.campus.model.vo.CollegeVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CollegeServiceTest {

    @Resource
    private CollegeMapper collegeMapper;

    @Test
    void getAllCollege() {
        List<CollegeVo> collegeVos = collegeMapper.getAllCollege();
        System.out.println(collegeVos);
    }

}
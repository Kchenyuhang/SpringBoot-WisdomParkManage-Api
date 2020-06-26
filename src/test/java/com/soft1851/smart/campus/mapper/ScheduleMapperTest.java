package com.soft1851.smart.campus.mapper;

import com.soft1851.smart.campus.utils.Md5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/25
 * @Version 1.0
 */
@SpringBootTest
class ScheduleMapperTest {
    @Resource
    private ScheduleMapper scheduleMapper;

    @Test
    void getScheduleSemesterClazzById() {
        System.out.println(scheduleMapper.getScheduleSemesterClazzById(1));
    }

    @Test
    void getPassword(){
        System.out.println(Md5Util.getMd5("123456", true, 32));
    }
}
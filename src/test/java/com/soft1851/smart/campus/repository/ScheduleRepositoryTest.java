package com.soft1851.smart.campus.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ScheduleRepositoryTest {

    @Resource
    private ScheduleRepository scheduleRepository;

    @Test
    void getIdInfo() {
        scheduleRepository.getIdInfo(1L, 1L, 1).forEach(System.out::println);
    }
}
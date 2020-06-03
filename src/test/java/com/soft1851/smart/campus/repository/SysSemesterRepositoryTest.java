package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysSemester;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysSemesterRepositoryTest {

    @Resource
    private SysSemesterRepository sysSemesterRepository;

    @Test
    void updateSemesterById() {
        SysSemester sysSemester = SysSemester.builder()
                .name("学期名被修改")
                .pkSemesterId(2L)
                .weekCount(15)
                .build();
        sysSemesterRepository.updateSemesterById(sysSemester);
    }
}
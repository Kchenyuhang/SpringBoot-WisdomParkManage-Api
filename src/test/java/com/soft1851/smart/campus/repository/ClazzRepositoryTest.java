package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.UpdateClazzDto;
import com.soft1851.smart.campus.model.entity.Clazz;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ClazzRepositoryTest {

    @Resource
    private ClazzRepository clazzRepository;
    @Test
    void getClazz() {
        Clazz clazz = clazzRepository.getClazz("软件18113");
        System.out.println(clazz);
    }

    @Test
    void increaseStudentToClazz() {
        List<String> ids = new ArrayList<>();
        ids.add("21");
        ids.add("22");
        clazzRepository.increaseStudentToClazz(ids,(long)2);
    }

    @Test
    void deleteClazz() {
        clazzRepository.deleteClazz((long)11);
    }

    @Test
    void updateClazz() {
        UpdateClazzDto updateClazzDto = UpdateClazzDto.builder()
                .clazzId((long)11)
                .clazzHeadmaster("1010000108")
                .collegeId((long)1)
                .grade("18级")
                .name("移动1811").build();
        clazzRepository.updateClazz(updateClazzDto);
    }
}
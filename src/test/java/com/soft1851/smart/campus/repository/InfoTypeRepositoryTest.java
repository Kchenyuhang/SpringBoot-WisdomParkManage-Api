package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.InfoType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InfoTypeRepositoryTest {
    @Resource
    private InfoTypeRepository infoTypeRepository;

    @Test
    void insert() {
        List<InfoType> infoTypeList = new ArrayList<>();

        InfoType infoType = InfoType.builder()
                .name("教务处")
                .sort(1)
                .isDeleted(true)
                .build();
        infoTypeList.add(infoType);
        InfoType infoType2 = InfoType.builder()
                .name("学生会")
                .sort(2)
                .isDeleted(true)
                .build();
        infoTypeList.add(infoType2);
        infoTypeRepository.saveAll(infoTypeList);
    }

    @Test
    void findTopByOrderBySortDesc() {
    }

    @Test
    void findByPkInfoTypeId() {
    }

    @Test
    void deleteBatch() {
    }
}
package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CardRepositoryTest {
    @Resource
    private  CardRepository cardRepository;

    @Test
    void deleteByPkCardId() {
        cardRepository.deleteByPkCardId(3L);
    }
}
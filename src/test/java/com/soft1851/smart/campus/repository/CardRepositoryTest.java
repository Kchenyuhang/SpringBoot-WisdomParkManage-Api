package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysCard;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CardRepositoryTest {
    @Resource
    private  CardRepository cardRepository;

    @Test
    void deleteByPkCardId() {
        cardRepository.deleteByPkCardId(3L);
    }

    @Test
    void deleteBatch() {
        List<Long> ids = new ArrayList<Long>();
        for (int i = 1; i <= 58; i++) {
            ids.add((long) i);
        }
        ids.add((long) 1);
        cardRepository.deleteBatch(ids);
    }

    @Test
    void testDeleteBatch() {
        List<Long> ids = new ArrayList<Long>();
        for (int i = 1; i <= 58; i++) {
            ids.add((long) i);
        }
        ids.add((long) 1);
        cardRepository.deleteBatch(ids);
    }

    @Test
    void getSysCardByJobNumber() {
        SysCard sysCard = cardRepository.getSysCardByJobNumber("1802343315");
        System.out.println(sysCard);
    }
}
package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.InfoManage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class InfoManageRepositoryTest {

    @Resource
    private InfoManageRepository infoManageRepository;

    @Test
    void testSelectAll() {
        List<InfoManage> list1 = infoManageRepository.findAll();
        log.info(String.valueOf(list1.size()));
    }

    /**
     * 增
     */
    @Test
    void insertInfoManage() {
        InfoManage infoManage = InfoManage.builder()
                .title("测试1")
                .cover("1.jpg")
                .text("测试内容")
                .isDeleted(true)
                .build();
        infoManageRepository.save(infoManage);
    }

    /**
     * 批量删除
     */
    @Test
    void deleteBatch() {
        List<Long> ids = new ArrayList<Long>();
        ids.add(201L);
        ids.add(202L);
        ids.add(203L);
        infoManageRepository.deleteBatch(ids);
    }

    @Test
    void updateInfoManage() {
        InfoManage infoManage = InfoManage.builder()
                .pkInfoManageId(1L)
                .title("修改")
                .cover("zyj.jpg")
                .text("修改内容")
                .isTop(true)
                .isDeleted(true)
                .build();
        infoManageRepository.saveAndFlush(infoManage);
    }
}
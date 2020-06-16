package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.FleaOrderBatchIdDto;
import com.soft1851.smart.campus.model.dto.FleaRewardBatchIdDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FleaCommentRepositoryTest {
    @Resource
    private FleaCommentRepository commentRepository;

    @Test
    void selectAll() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(4)
                .build();
        Pageable pageable = PageRequest.of(pageDto.getCurrentPage(),pageDto.getPageSize());
        System.out.println(commentRepository.selectAll(pageable));
    }

    @Test
    void batchlDel() {
        FleaRewardBatchIdDto idDto = new FleaRewardBatchIdDto();
        List<Long> id = new ArrayList<>();
        id.add(16l);
        id.add(17l);
        idDto.setId(id);
        System.out.println(commentRepository.batchlDel(id));
    }
}
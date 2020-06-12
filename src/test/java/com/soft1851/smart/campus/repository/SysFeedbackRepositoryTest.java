package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.UpdateSysFeedbackDto;
import com.soft1851.smart.campus.model.entity.SysFeedback;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SysFeedbackRepositoryTest
{
    @Resource
    private SysFeedbackRepository sysFeedbackRepository;

    @Test
    void name() {
        List<SysFeedback> sysFeedbacks = new ArrayList<>();
        for (int i=10 ;i<50 ;i++){
            SysFeedback sysFeedback = SysFeedback.builder()
                    .contactWay("178260123"+i)
                    .content("反馈内容"+i)
                    .title("标题"+i)
                    .isHandled(false)
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(false)
                    .build();
            sysFeedbacks.add(sysFeedback);
        }
        sysFeedbackRepository.saveAll(sysFeedbacks);
    }

    @Test
    void updateSysFeedback() {
        UpdateSysFeedbackDto sysFeedback = UpdateSysFeedbackDto.builder()
                .pkFeedbackId((long)1)
                .title("测试标题")
                .content("测试内容")
                .contactWay("13092037352")
                .build();
        sysFeedbackRepository.updateSysFeedback(sysFeedback);
    }

    @Test
    void deleted() {
        sysFeedbackRepository.deleteSysFeedback((long)1);

    }

    @Test
    void sss() {
        List<Long> longList = new ArrayList<>();
        longList.add((long) 1);
        longList.add((long) 2);
        longList.add((long) 4);
        longList.add((long) 5);
        longList.add((long) 6);
        sysFeedbackRepository.deleteBatchByPkFeedbackId(longList);
    }
}
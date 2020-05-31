package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.repository.ExaminationRepository;
import com.soft1851.smart.campus.service.ExaminationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author xunmi
 * @ClassName ExaminationServiceImpl
 * @Description TODO
 * @Date 2020/5/31
 * @Version 1.0
 **/
@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Resource
    private ExaminationRepository examinationRepository;

    @Override
    public void updateInfo(Examination examination) {
        createDate(examination);
        examinationRepository.updateInfo(examination);
    }

    @Override
    public void increaseInfo(Examination examination) {
        createDate(examination);
        examinationRepository.saveAndFlush(examination);
    }

    /**
     * 为 examination对象补充属性值的方法
     *
     * @param examination
     */
    private void createDate(Examination examination) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (examination.getGmtCreate() == null) {
            examination.setGmtCreate(timestamp);
        }
        if (examination.getGmtModified() == null) {
            examination.setGmtModified(timestamp);
        }
        examination.setIsDeleted(false);
    }
}

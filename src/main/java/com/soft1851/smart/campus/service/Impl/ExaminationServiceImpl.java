package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.model.vo.EntityVo;
import com.soft1851.smart.campus.model.vo.ExaminationVo;
import com.soft1851.smart.campus.repository.ExaminationRepository;
import com.soft1851.smart.campus.service.ExaminationService;
import com.soft1851.smart.campus.utils.DataTypeChange;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<EntityVo> findAllByPage(PageDto pageDto) {
        // 第一步：调用底层 Repository 中的分页查询方法，返回结果为 List<Object> 对象
        List<Object> examinationVos = examinationRepository.selectAll(pageDto);
        // 第二步：调用工具类，处理 List<Object> 对象
        return DataTypeChange.changeObj(examinationVos, ExaminationVo.class);
    }

    @Override
    public Long countNum() {
        return examinationRepository.count();
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

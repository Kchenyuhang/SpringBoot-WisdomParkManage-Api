package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.model.vo.ExaminationVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author xunmi
 * @ClassName ExaminationService
 * @Description 考务业务逻辑层
 * @Date 2020/5/31
 * @Version 1.0
 **/
public interface ExaminationService {

    /**
     * 修改考务信息
     *
     * @param examination
     */
    void updateInfo(Examination examination);

    /**
     * 新增考务信息
     *
     * @param examination
     */
    void increaseInfo(Examination examination);

    /**
     * 分页查找所有考务信息数据
     *
     * @param pageDto
     * @return
     */
    List<ExaminationVo> findAllByPage(PageDto pageDto);
}

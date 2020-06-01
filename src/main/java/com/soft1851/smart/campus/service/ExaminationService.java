package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.Examination;

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
     * 新增考务信息     *
     * @param examination
     */
    void increaseInfo(Examination examination);
}

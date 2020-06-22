package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.UpdateNewExaminationDto;
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
     * @param updateNewExaminationDto
     * @return
     */
    ResponseResult updateInfo(UpdateNewExaminationDto updateNewExaminationDto);

    /**
     * 新增考务信息
     * @param examination
     * @return
     */
    ResponseResult increaseInfo(Examination examination);

    /**
     * 查询所有教务数据
     * @return
     */
    ResponseResult selectAllExamination();


    /**
     * 统计出考务数据的总数
     *
     * @return
     */
    Long countNum();


}

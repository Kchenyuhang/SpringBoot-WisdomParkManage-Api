package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.SysSemester;

import java.util.List;

/**
 * @author xunmi
 * @ClassName SysSemesterService
 * @Description 学期业务逻辑层
 * @Date 2020/6/1
 * @Version 1.0
 **/
public interface SysSemesterService {

    /**
     * 查询所有学期信息的方法
     *
     * @return
     */
    List<SysSemester> findAll();
}

package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.Clazz;

import java.util.List;

/**
 * @author xunmi
 * @ClassName ClazzService
 * @Description 班级业务逻辑层
 * @Date 2020/6/1
 * @Version 1.0
 **/
public interface ClazzService {

    /**
     * 查询班级表中的所有数据
     *
     * @return
     */
    List<Clazz> findAll();
}

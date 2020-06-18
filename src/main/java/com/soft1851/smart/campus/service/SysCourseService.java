package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysCourse;

import java.util.List;
import java.util.Map;

/**
 * @author xunmi
 * @ClassName SysCourseService
 * @Description 课程表中的课程业务逻辑层
 * @Date 2020/5/31
 * @Version 1.0
 **/
public interface SysCourseService {

    /**
     * 新增课程的方法
     *
     * @param sysCourse
     */
    void increase(SysCourse sysCourse);

    /**
     * 查询所有课程信息
     * @return
     */
    List<Map<String, Object>> getAllCourses(PageDto pageDto);
}

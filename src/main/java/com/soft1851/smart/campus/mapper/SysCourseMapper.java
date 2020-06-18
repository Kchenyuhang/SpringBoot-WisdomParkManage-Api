package com.soft1851.smart.campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.smart.campus.model.entity.SysCourse;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/18
 * @Version 1.0
 */
public interface SysCourseMapper extends BaseMapper<SysCourse> {

    @Select(value = "SELECT c.pk_course_id,c.time, c.week_day, c.week_duration, c.gmt_create,c.schedule_id, c.subject_id, c.room_id, r.name, u.user_name FROM sys_course c " +
            "LEFT JOIN room r " +
            "ON r.id = c.room_id " +
            "LEFT JOIN user_account u " +
            "ON c.user_job_number = u.job_number " +
            "ORDER BY gmt_create DESC " +
            "LIMIT ${pageSize*(currentPage-1)}, #{pageSize}")
    List<Map<String, Object>> getAllSysCourse(int currentPage, int pageSize);
}

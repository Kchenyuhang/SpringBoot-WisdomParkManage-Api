package com.soft1851.smart.campus.repository;

import com.fasterxml.jackson.databind.ObjectReader;
import com.soft1851.smart.campus.model.entity.Schedule;
import com.soft1851.smart.campus.model.entity.SysCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author xunmi
 * @ClassName SysCourseRepository
 * @Description TODO
 * @Date 2020/5/29
 * @Version 1.0
 **/
public interface SysCourseRepository extends JpaRepository<SysCourse, Long> {
    /**
     * 通过课表 id 查找出课表的信息
     *
     * @param scheduleId
     * @return 科目id   教师工号   教室id   星期几上课   上课时间段
     */
    @Query(value = "SELECT subject_id, user_job_number, room_id, week_day, time " +
            "FROM sys_course " +
            "WHERE timetable_id = ?1", nativeQuery = true)
    List<SysCourse> getIdInfo(Long scheduleId);

}

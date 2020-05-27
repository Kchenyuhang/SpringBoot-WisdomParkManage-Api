package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.Permission;
import com.soft1851.smart.campus.model.entity.SysCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author xunmi
 * @ClassName ScheduleRepository
 * @Description TODO
 * @Date 2020/5/26
 * @Version 1.0
 **/
public interface ScheduleRepository extends JpaRepository<Permission, Long> {

    /**
     * 查询指定 学期 班级 周次 的课表信息
     *
     * @param semesterId 学期
     * @param clazzId    班级
     * @param week       周次
     * @return 科目id   教师工号   教室id   星期几上课   上课时间段
     */
//    @Query(value = "SELECT subject_id, user_job_number, room_id, week_day, time\n" +
//            "FROM sys_course\n" +
//            "WHERE schedule_id = (\n" +
//            " SELECT pk_schedule_id FROM schedule \n" +
//            " WHERE semester_id = ?1 AND clazz_id = ?2 AND week = ?3\n" +
//            ")", nativeQuery = true)
    @Query(value = "SELECT * FROM sys_course", nativeQuery = true)
    List<SysCourse> getIdInfo(Long semesterId, Long clazzId, Integer week);


}

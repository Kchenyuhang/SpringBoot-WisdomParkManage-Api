package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.mapper.*;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Schedule;
import com.soft1851.smart.campus.model.entity.SysCourse;
import com.soft1851.smart.campus.model.entity.UserAccount;
import com.soft1851.smart.campus.repository.SysCourseRepository;
import com.soft1851.smart.campus.repository.SysSubjectRepository;
import com.soft1851.smart.campus.service.SysCourseService;
import com.soft1851.smart.campus.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.security.auth.Subject;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author xunmi
 * @ClassName SysCourse
 * @Description TODO
 * @Date 2020/6/1
 * @Version 1.0
 **/
@Service
public class SysCourseServiceImpl implements SysCourseService {

    @Resource
    private SysCourseRepository sysCourseRepository;
    @Resource
    private SysCourseMapper sysCourseMapper;
    @Resource
    private ScheduleMapper scheduleMapper;
    @Resource
    private RoomMapper roomMapper;
    @Resource
    private UserAccountMapper userAccountMapper;
    @Resource
    private SysSubjectRepository sysSubjectRepository;

    @Override
    public void increase(SysCourse sysCourse) {
        Timestamp timestamp = DateUtil.getTimestamp();
        if (sysCourse.getGmtCreate() == null) {
            sysCourse.setGmtCreate(timestamp);
        }
        if (sysCourse.getGmtModified() == null) {
            sysCourse.setGmtModified(timestamp);
        }
        sysCourse.setIsDeleted(false);
        sysCourseRepository.saveAndFlush(sysCourse);
    }

    @Override
    public List<Map<String, Object>> getAllCourses(PageDto pageDto) {
        List<Map<String, Object>> courses = sysCourseMapper.getAllSysCourse(pageDto.getCurrentPage(), pageDto.getPageSize());
        courses.forEach(course -> {
            System.out.println(course);
            Map<String, Object> semester = scheduleMapper.getScheduleSemesterById(Long.parseLong(course.get("schedule_id").toString()));
            String subject = sysSubjectRepository.getSubjectName(Long.parseLong(course.get("subject_id").toString()));
            Map<String, Object> tower = roomMapper.getRoomTowerByRoomId(Long.parseLong(course.get("room_id").toString()));
            course.put("subjectName", subject);
            course.put("semesterName", semester.get("name"));
            course.put("classRoom", tower.get("name").toString() + course.get("name"));
        });
        return courses;
    }
}

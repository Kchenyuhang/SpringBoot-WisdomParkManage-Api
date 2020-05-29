package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.model.entity.SysCourse;
import com.soft1851.smart.campus.model.vo.CourseVo;
import com.soft1851.smart.campus.repository.*;
import com.soft1851.smart.campus.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xunmi
 * @ClassName ScheduleServiceImpl
 * @Description TODO
 * @Date 2020/5/30
 * @Version 1.0
 **/
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleRepository scheduleRepository;

    @Resource
    private SysCourseRepository sysCourseRepository;

    @Resource
    private SysSubjectRepository sysSubjectRepository;

    @Resource
    private RoomRepository roomRepository;

    @Resource
    private UserAccountRepository userAccountRepository;


    @Override
    public List<CourseVo> getScheduleInfo(Long semesterId, Long clazzId, Integer week) {
        List<CourseVo> list = new ArrayList<>(10);
        // 第一步：通过指定的学期、班级、周次查找出课程表的 id
        Long scheduleId = scheduleRepository.getId(semesterId, clazzId, week);
        // 第二步：通过课程表 id 查找出对应课程、老师、教室的 id值
        List<SysCourse> infoOfId = sysCourseRepository.getInfoOfId(scheduleId);
        // 第三步：遍历集合，分别将各类 id 取出并进行查询
        return createVo(infoOfId);
    }

    @Override
    public List<CourseVo> getScheduleInfoById(Long scheduleId) {
        List<SysCourse> infoOfId = sysCourseRepository.getInfoOfId(scheduleId);
        return createVo(infoOfId);
    }

    /**
     * 构造 Vo 对象并返回
     *
     * @param infoOfId
     * @return
     */
    private List<CourseVo> createVo(List<SysCourse> infoOfId) {
        List<CourseVo> list = new ArrayList<>(10);
        // 第三步：遍历集合，分别将各类 id 取出并进行查询
        infoOfId.forEach((item) -> {
            CourseVo course = new CourseVo();
            // 先获取科目信息
            course.setSubjectName(sysSubjectRepository.getSubjectName(item.getSubjectId()));
            // 获取教室信息
            course.setRoomName(roomRepository.getRoomName((long) item.getRoomId()));
            // 获取教师信息
            course.setTeacherName(userAccountRepository.getUserName(item.getUserJobNumber()));
            // 获取节次
            course.setTime(item.getTime());
            // 获取上课的时间
            course.setWeekDay(item.getWeekDay());
            // 获取周次
            course.setWeekDuration(item.getWeekDuration());
            list.add(course);
        });
        return list;
    }
}

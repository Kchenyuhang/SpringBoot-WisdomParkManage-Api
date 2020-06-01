package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.model.entity.SysCourse;
import com.soft1851.smart.campus.repository.SysCourseRepository;
import com.soft1851.smart.campus.service.SysCourseService;
import com.soft1851.smart.campus.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

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
}

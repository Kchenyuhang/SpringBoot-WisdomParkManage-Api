package com.soft1851.smart.campus.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1851.smart.campus.mapper.JobTypeMapper;
import com.soft1851.smart.campus.model.entity.JobType;
import com.soft1851.smart.campus.service.JobTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author su
 * @className JobTypeServiceImpl
 * @Description TODO
 * @Date 2020/6/17
 * @Version 1.0
 **/
@Service
public class JobTypeServiceImpl extends ServiceImpl<JobTypeMapper, JobType> implements JobTypeService {


    @Resource
    private JobTypeMapper jobTypeMapper;

    @Override
    public List<JobType> typeList() {
        QueryWrapper<JobType> wrapper = new QueryWrapper<>();
        wrapper.select("pk_job_type_id","name","parent_id","is_deleted", "gmt_create", "gmt_modified");
        return jobTypeMapper.selectList(wrapper);
    }

}
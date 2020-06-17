package com.soft1851.smart.campus.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1851.smart.campus.mapper.PartJobMapper;
import com.soft1851.smart.campus.model.dto.JobPageDto;
import com.soft1851.smart.campus.model.entity.PartJob;
import com.soft1851.smart.campus.service.PartJobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author su
 * @className PartJobServiceImpl
 * @Description TODO
 * @Date 2020/6/17
 * @Version 1.0
 **/
@Service
public class PartJobServiceImpl extends ServiceImpl<PartJobMapper, PartJob> implements PartJobService {

    @Resource
    private PartJobMapper partJobMapper;

    @Override
    public List<PartJob> findList(JobPageDto jobPageDto) {
        QueryWrapper<PartJob> wrapper =  new QueryWrapper<>();
        IPage<PartJob> page = new Page<>(jobPageDto.getCurrentPage(), jobPageDto.getPageSize());
        return partJobMapper.selectPage(page, wrapper).getRecords();
    }
}

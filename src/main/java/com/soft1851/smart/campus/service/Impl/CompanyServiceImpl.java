package com.soft1851.smart.campus.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1851.smart.campus.mapper.CompanyMapper;
import com.soft1851.smart.campus.model.dto.JobPageDto;
import com.soft1851.smart.campus.model.entity.Company;
import com.soft1851.smart.campus.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author su
 * @className CompanyServiceIMPL
 * @Description TODO
 * @Date 2020/6/17
 * @Version 1.0
 **/
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public List<Company> findAll(JobPageDto jobPageDto) {
        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        IPage<Company> page = new Page<>(jobPageDto.getCurrentPage(), jobPageDto.getPageSize());
        return companyMapper.selectPage(page, wrapper).getRecords();
    }
}

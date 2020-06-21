package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.model.entity.SysSubject;
import com.soft1851.smart.campus.repository.SysSubjectRepository;
import com.soft1851.smart.campus.service.SysSubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/21
 * @Version 1.0
 */
@Service
public class SysSubjectServiceImpl implements SysSubjectService {
    @Resource
    private SysSubjectRepository sysSubjectRepository;

    @Override
    public List<SysSubject> selectAll() {
        return sysSubjectRepository.findAll();
    }
}

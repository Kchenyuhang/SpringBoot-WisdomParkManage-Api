package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.model.entity.Clazz;
import com.soft1851.smart.campus.repository.ClazzRepository;
import com.soft1851.smart.campus.service.ClazzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xunmi
 * @ClassName ClazzServiceImpl
 * @Description TODO
 * @Date 2020/6/1
 * @Version 1.0
 **/
@Service
public class ClazzServiceImpl implements ClazzService {

    @Resource
    private ClazzRepository clazzRepository;

    @Override
    public List<Clazz> findAll() {
        return clazzRepository.findAll();
    }
}

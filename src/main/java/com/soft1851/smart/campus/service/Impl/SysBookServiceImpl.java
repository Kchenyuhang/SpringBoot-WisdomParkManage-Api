package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.repository.SysBookRepository;
import com.soft1851.smart.campus.service.SysBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysBookServiceImpl
 * @Description TODO
 * @date 2020-06-13 13:41
 **/
@Service
public class SysBookServiceImpl implements SysBookService {
    @Resource
    private SysBookRepository sysBookRepository;

    @Override
    public ResponseResult findAllSysBookByPage(PageDto pageDto) {
        return null;
    }
}

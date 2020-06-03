package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysBook;
import com.soft1851.smart.campus.model.entity.SysBorrow;
import com.soft1851.smart.campus.repository.SysBorrowRepository;
import com.soft1851.smart.campus.service.SysBorrowService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/3 12:57
 * @Version 1.0
 **/
@Service
public class SysBorrowServiceImpl implements SysBorrowService {
    @Resource
    private SysBorrowRepository sysBorrowRepository;

    @Override
    public ResponseResult findAllByPage(PageDto pageDto) {

        //分页要减一
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage() - 1,
                pageDto.getPageSize());
        Page<SysBorrow> sysBorrow = sysBorrowRepository.findAll(pageable);
        System.out.println("*********************");
        System.out.println(sysBorrow);
        System.out.println("*********************");
        return ResponseResult.success(sysBorrow);
    }
}

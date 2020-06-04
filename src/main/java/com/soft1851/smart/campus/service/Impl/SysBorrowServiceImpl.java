package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BorrowDto;
import com.soft1851.smart.campus.model.dto.BorrowInsertDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysBorrow;
import com.soft1851.smart.campus.repository.SysBorrowRepository;
import com.soft1851.smart.campus.service.SysBorrowService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public ResponseResult getBorrowByTime(BorrowDto borrowDto) {
        //分页要减一
        Pageable pageable = PageRequest.of(
                borrowDto.getCurrentPage() - 1,
                borrowDto.getPageSize());
        //查询所有符合条件的
        List<SysBorrow> sysBorrows = sysBorrowRepository.getSysBorrowsByGmtModifiedBetween(Timestamp.valueOf(borrowDto.getStartTime()), Timestamp.valueOf(borrowDto.getEndTime()));
        Page<SysBorrow> sysBorrowInfo = new PageImpl<SysBorrow>(sysBorrows,pageable,sysBorrows.size());
        System.out.println("*********************");
        System.out.println(sysBorrowInfo);
        System.out.println("*********************");
        return ResponseResult.success(sysBorrowInfo);
    }

    @Override
    public ResponseResult borrowInsert(BorrowInsertDto borrowInsertDto) {
        SysBorrow sysBorrow = SysBorrow.builder()
                .borrowBookName(borrowInsertDto.getBorrowBookName())
                .borrowUserNumber(borrowInsertDto.getBorrowUserNumber())
                .borrowUserPhone(borrowInsertDto.getBorrowUserPhone())
                .borrowUserName(borrowInsertDto.getBorrowUserName())
                .borrowBookId(borrowInsertDto.getBorrowBookId())
                .pkBorrowId(Long.valueOf(borrowInsertDto.getBorrowBookId()))
                .isDeleted(false)
                .isReturned(false)
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        sysBorrowRepository.save(sysBorrow);
        return ResponseResult.success();
    }
}

package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.mapper.SysBorrowMapper;
import com.soft1851.smart.campus.model.dto.BorrowDto;
import com.soft1851.smart.campus.model.dto.BorrowInsertDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.TimeBorrowPageDto;
import com.soft1851.smart.campus.model.entity.SysBorrow;
import com.soft1851.smart.campus.repository.SysBorrowRepository;
import com.soft1851.smart.campus.service.SysBorrowService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
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
    @Resource
    private SysBorrowMapper sysBorrowMapper;

    @Override
    public ResponseResult findAllByPage(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkBorrowId");
        Page<SysBorrow> sysBorrow = sysBorrowRepository.findAll(pageable);
        return ResponseResult.success(sysBorrow.getContent());
    }

    @Override
    public ResponseResult getBorrowByTime(BorrowDto borrowDto) {
        //分页要减一
        Pageable pageable = PageRequest.of(
                borrowDto.getCurrentPage(),
                borrowDto.getPageSize());
        //查询所有符合条件的
        List<SysBorrow> sysBorrows = sysBorrowRepository.getSysBorrowsByGmtCreateBetween(Timestamp.valueOf(borrowDto.getStartTime()), Timestamp.valueOf(borrowDto.getEndTime()));
        Page<SysBorrow> sysBorrowInfo = new PageImpl<SysBorrow>(sysBorrows,pageable,sysBorrows.size());
        return ResponseResult.success(sysBorrowInfo.getContent());
    }

    @Override
    public ResponseResult borrowInsert(BorrowInsertDto borrowInsertDto) {
        SysBorrow sysBorrow = SysBorrow.builder()
                .borrowBookName(borrowInsertDto.getBorrowBookName())
                .borrowUserNumber(borrowInsertDto.getBorrowUserNumber())
                .borrowUserPhone(borrowInsertDto.getBorrowUserPhone())
                .borrowUserName(borrowInsertDto.getBorrowUserName())
                .borrowBookId(borrowInsertDto.getBorrowBookId())
                .isReturned(false)
                .gmtReturn(Timestamp.valueOf(LocalDateTime.now()))
                .isDeleted(false)
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        sysBorrowRepository.save(sysBorrow);
        return ResponseResult.success();
    }

    /**
     * 修改借阅状态
     * @param id
     * @param isDeleted
     * @return
     */
    @Override
    public ResponseResult deletedSysRole(Long id, Boolean isDeleted) {
        sysBorrowRepository.setIsDeletedByPkBorrowId(id,isDeleted);
        return ResponseResult.success();
    }

    /**
     * 查询时间内的数据
     * @param timeBorrowPageDto
     * @return
     */
    @Override
    public ResponseResult getSysBorrowsByTime(TimeBorrowPageDto timeBorrowPageDto) {
        Timestamp timestamp = Timestamp.valueOf(timeBorrowPageDto.getStartTime());
        Timestamp timestamp1 = Timestamp.valueOf(timeBorrowPageDto.getEndTime());
        List<SysBorrow> sysBorrowList = null;
        try {
            sysBorrowList = sysBorrowMapper.getSysBorrowsByTime(timestamp,timestamp1,timeBorrowPageDto.getCurrentPage(),timeBorrowPageDto.getPageSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseResult.success(sysBorrowList);
    }


}

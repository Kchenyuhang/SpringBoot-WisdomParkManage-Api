package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.SysBookDto;
import com.soft1851.smart.campus.model.entity.SysBook;
import com.soft1851.smart.campus.repository.BookRepository;
import com.soft1851.smart.campus.repository.BorrowRepository;
import com.soft1851.smart.campus.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/1 8:16
 * @Version 1.0
 **/
@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository bookRepository;
    @Resource
    private BorrowRepository borrowRepository;

    /**
     * 添加一种图书
     *
     * @param sysBookDto
     * @return
     */
    @Override
    public ResponseResult increaseSysBook(@Validated SysBookDto sysBookDto) {
        log.info("sysBookDto>>>>>>>>>,{}", sysBookDto);
        SysBook sysBook = SysBook.builder()
                .author(sysBookDto.getAuthor())
                .cover(sysBookDto.getCover())
                .type(sysBookDto.getType())
                .description(sysBookDto.getDescription())
                .bookName(sysBookDto.getBookName())
                .bookNumber(sysBookDto.getBookNumber())
                .bookResidueNumber(sysBookDto.getBookNumber())
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .status(false)
                .isDeleted(false)
                .build();
        System.out.println(sysBook);
        bookRepository.save(sysBook);
        return ResponseResult.success(ResultCode.SUCCESS);
    }

    /**
     * 批量删除图书种类
     * @param idsArray
     * @return
     */
    @Override
    public ResponseResult deletedBatchSysBook(String idsArray) {
        String[] array = idsArray.substring(1, idsArray.length() - 1).split("\\,");
        List<Long> ids = new ArrayList<>();
        for (String id : array) {
            ids.add(Long.valueOf(id));
        }
        log.info("需要删除的图书种类id>>>>>>>>>,{}", idsArray);
        int i = bookRepository.deleteBatchBook(ids);
        System.out.println("删除" + i + "种");
        log.info("删除" + i + "种");
        return ResponseResult.success();
    }
}

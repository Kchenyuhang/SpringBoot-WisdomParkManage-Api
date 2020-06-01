package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BookBatchDeleteDto;
import com.soft1851.smart.campus.model.dto.SysBookDto;
import com.soft1851.smart.campus.model.entity.SysBook;
import com.soft1851.smart.campus.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/1 11:44
 * @Version 1.0
 **/
@RestController
@Slf4j
public class SysBookController {
    @Resource
    private BookService bookService;

    @PostMapping("/book/increased")
    ResponseResult increasedBook(@RequestBody SysBookDto sysBookDto) {
        return bookService.increaseSysBook(sysBookDto);
    }

    @DeleteMapping("/book/deletion/batch")
    ResponseResult batchDeletedBook(@RequestBody BookBatchDeleteDto bookBatchDeleteDto) {
        return bookService.deletedBatchSysBook(bookBatchDeleteDto.getIds());
    }
}

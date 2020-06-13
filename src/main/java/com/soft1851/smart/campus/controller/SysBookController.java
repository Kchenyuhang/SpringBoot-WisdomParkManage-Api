package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BookBatchDeleteDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.QueryDto;
import com.soft1851.smart.campus.model.dto.SysBookDto;
import com.soft1851.smart.campus.service.BookService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
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
@Api(tags = "图书管理接口")
public class SysBookController {
    @Resource
    private BookService bookService;

    @PostMapping("/book/increased")
    ResponseResult increasedBook(@RequestBody SysBookDto sysBookDto) {
        return bookService.increaseSysBook(sysBookDto);
    }
    /**
     * 删除一卡通信息
     * @param queryDto
     * @return
     */
    @PostMapping("/book/id")
    ResponseResult deleteCard(@RequestBody QueryDto queryDto){
        return bookService.deleteBook(Long.parseLong(queryDto.getField().toString()));
    }
    /***
     * 批量删除
     * @param bookBatchDeleteDto
     * @return
     */
    @PostMapping("/book/deletion/batch")
    ResponseResult batchDeletedBook(@RequestBody BookBatchDeleteDto bookBatchDeleteDto) {
            return bookService.deletedBatchSysBook(bookBatchDeleteDto.getIds());
    }


    @PostMapping("book/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto) {
        return bookService.findAllByPage(pageDto);
    }

    @PostMapping("/book/updation")
    ResponseResult updatedBook(@RequestBody SysBookDto sysBookDto) {
        return bookService.updatedBook(sysBookDto);
    }

}

package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Resource
    private BookService bookService;
    @Test
    void deleteBook() {
        ResponseResult responseResult = bookService.deleteBook((long)1);
        System.out.println(responseResult);
    }
}
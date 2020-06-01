package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepositoryTest {
    @Resource
    private BookRepository bookRepository;
    @Test
    void findBookNumberByBookName() {
        System.out.println("**************************");
        System.out.println(bookRepository.findBookNumberByBookName("《JAVA 网络编程 第 4 版》"));
        System.out.println("**************************");
    }
}
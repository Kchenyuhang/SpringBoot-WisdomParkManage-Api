package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysBook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;

@SpringBootTest
class BookRepositoryTest {

    @Resource
    private BookRepository bookRepository;

    @Test
    void name() {
        Pageable pageable = PageRequest.of(
                1,
                3,
                Sort.Direction.DESC,
                "gmt_create");
        Page<SysBook> sysBooks = bookRepository.getAllSysBook(pageable);
        System.out.println(sysBooks.getContent());
    }
}
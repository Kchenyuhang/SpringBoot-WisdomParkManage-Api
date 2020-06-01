package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

        @Resource
    private BookRepository bookRepository;
    @Test
    void deletedBatchSysBook() {
////        String s = "14";
////        System.out.println(Long.valueOf(s)+1);
        String arr = "[51,52,53,99]";
//
        List<Long> ids = new ArrayList<>();
        String[] array = arr.substring(1, arr.length() - 1).split("\\,");
        for (String id : array) {
            ids.add(Long.valueOf(id));
            System.out.println(Long.valueOf(id)+100);
        }
        System.out.println(ids);

        int i = bookRepository.deleteBatchBook(ids);
        System.out.println("删除"+i+"条");
    }
}
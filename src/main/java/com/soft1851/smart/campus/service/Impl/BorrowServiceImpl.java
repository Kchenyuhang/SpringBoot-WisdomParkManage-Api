package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.repository.BookRepository;
import com.soft1851.smart.campus.service.BorrowService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/1 8:16
 * @Version 1.0
 **/
@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    private BookRepository bookRepository;
    @Override
    public int findBookNumberByBookName(String bookName) {
        return bookRepository.findBookNumberByBookName(bookName);
    }
}

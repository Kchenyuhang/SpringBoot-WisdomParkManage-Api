package com.soft1851.smart.campus.service;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/1 8:16
 * @Version 1.0
 **/
public interface BorrowService {
    /**
     * 查询本书名未还书籍的数量
     * @param bookName
     * @return
     */
    int findBookNumberByBookName(String bookName);
}

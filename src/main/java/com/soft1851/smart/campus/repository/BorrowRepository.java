package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 借阅
 * @Author 涛涛
 * @Date 2020/6/1 8:12
 * @Version 1.0
 **/
public interface BorrowRepository extends JpaRepository<SysBorrow, Long> {
    /**
     * 查询本书名未还书籍的数量
     * @param bookName
     * @return
     */
    @Query(value = "SELECT COUNT(pk_borrow_id) from sys_borrow where borrow_book_name=?1 and is_returned=false ", nativeQuery = true)
    int findBookNumberByBookName(String bookName);

}

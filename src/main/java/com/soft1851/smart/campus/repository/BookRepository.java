package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description 图书
 * @Author 涛涛
 * @Date 2020/6/1 8:11
 * @Version 1.0
 **/
public interface BookRepository extends JpaRepository<SysBook, Long> {

    @Query(value = "SELECT COUNT(pk_book_id) from sys_book where book_name=?1", nativeQuery = true)
    int findBookNumberByBookName(String bookName);

    @Transactional
    @Modifying
    @Query(value = "update sys_book set book_number=?2 where book_name=?1", nativeQuery = true)
    int setBookNumberByBookName(String bookName,int bookNumber);

    @Transactional
    @Modifying
    @Query(value = "update sys_book set book_residue_number=?2 where book_name=?1", nativeQuery = true)
    int setBookResidueByBookName(String bookName, int bookResidueNumber);

    /**
     * 批量删除书籍种类
     *
     * @return
     */
    @Modifying
    @Transactional(timeout = 10, rollbackFor = RuntimeException.class)
    @Query(value = "delete from SysBook  s where s.pkBookId in (?1)")
    int deleteBatchBook(List<Long> ids);

}

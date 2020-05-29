package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author xunmi
 * @ClassName SysSubjectRepository
 * @Description TODO
 * @Date 2020/5/29
 * @Version 1.0
 **/
public interface SysSubjectRepository extends JpaRepository<SysSubject, Long> {

    @Query(value = "SELECT name FROM sys_subject WHERE pk_subject_id = ?1", nativeQuery = true)
    String getSubjectName(Long id);
}

package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysSemester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author xunmi
 * @ClassName SemesterRepository
 * @Description 学期相关操作的类
 * @Date 2020/6/1
 * @Version 1.0
 **/
public interface SysSemesterRepository extends JpaRepository<SysSemester, Long> {

    @Query("UPDATE SysSemester SET name=:#{#sysSemester.name}," +
            "weekCount=:#{#sysSemester.weekCount} WHERE pkSemesterId=:#{#sysSemester.pkSemesterId}")
    void updateSemesterById(@Param("sysSemester") SysSemester sysSemester);
}

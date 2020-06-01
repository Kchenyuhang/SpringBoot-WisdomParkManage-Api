package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.SysSemester;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xunmi
 * @ClassName SemesterRepository
 * @Description 学期相关操作的类
 * @Date 2020/6/1
 * @Version 1.0
 **/
public interface SysSemesterRepository extends JpaRepository<SysSemester, Long> {

}

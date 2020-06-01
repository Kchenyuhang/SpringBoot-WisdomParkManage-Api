package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xunmi
 * @ClassName ClazzService
 * @Description 班级相关操作的类
 * @Date 2020/6/1
 * @Version 1.0
 **/
public interface ClazzRepository extends JpaRepository<Clazz, Long> {

}

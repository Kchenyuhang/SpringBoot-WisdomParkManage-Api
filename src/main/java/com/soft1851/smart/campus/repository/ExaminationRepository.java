package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xunmi
 * @ClassName ExaminationRepository
 * @Description 考务管理相关操作的类
 * @Date 2020/5/31
 * @Version 1.0
 **/
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

    /**
     * 修改考务信息
     *
     * @param examination
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE examination \n" +
            "SET semester = :#{#examination.semester}, subject_id = :#{#examination.subjectId}, " +
            "clazz_id = :#{#examination.clazzId}, teacher_name = :#{#examination.teacherName}, " +
            "start_time = :#{#examination.startTime}, area = :#{#examination.area}, " +
            "score = :#{#examination.score}, is_deleted = :#{#examination.isDeleted}, " +
            "gmt_create = :#{#examination.gmtCreate}, gmt_modified = :#{#examination.gmtModified} \n" +
            "WHERE pk_examination_id = :#{#examination.pkExaminationId}", nativeQuery = true)
    void updateInfo(@Param("examination") Examination examination);
}

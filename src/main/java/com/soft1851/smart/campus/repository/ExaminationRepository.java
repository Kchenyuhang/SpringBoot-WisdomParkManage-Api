package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(rollbackFor = RuntimeException.class)
    @Modifying
    @Query(value = "UPDATE examination \n" +
            "SET semester = :#{#examination.semester}, subject_id = :#{#examination.subjectId}, " +
            "clazz_id = :#{#examination.clazzId}, teacher_name = :#{#examination.teacherName}, " +
            "start_time = :#{#examination.startTime}, area = :#{#examination.area}, " +
            "score = :#{#examination.score}, is_deleted = :#{#examination.isDeleted}, " +
            "gmt_create = :#{#examination.gmtCreate}, gmt_modified = :#{#examination.gmtModified} \n" +
            "WHERE pk_examination_id = :#{#examination.pkExaminationId}", nativeQuery = true)
    void updateInfo(@Param("examination") Examination examination);

    /**
     * 查询出所有与考务的基本信息
     *
     * @param pageDto
     * @return
     */
    @Query(value = "SELECT exa.pk_examination_id, exa.semester, exa.teacher_name, exa.start_time, \n" +
            "exa.area, exa.score, exa.type, exa.gmt_create, sub.name as subject_name, cl.name as clazz_name\n" +
            "FROM examination exa\n" +
            "LEFT JOIN sys_subject sub\n" +
            "ON exa.subject_id = sub.pk_subject_id\n" +
            "LEFT JOIN clazz cl\n" +
            "ON exa.clazz_id = cl.pk_clazz_id\n" +
            "ORDER BY exa.pk_examination_id\n" +
            "LIMIT :#{#pageDto.pageSize} OFFSET :#{#pageDto.currentPage}", nativeQuery = true)
    List<Object> selectAll(@Param("pageDto") PageDto pageDto);


}

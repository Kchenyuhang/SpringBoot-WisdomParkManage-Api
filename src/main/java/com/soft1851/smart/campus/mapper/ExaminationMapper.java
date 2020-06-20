package com.soft1851.smart.campus.mapper;

import com.soft1851.smart.campus.model.entity.Examination;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Tao
 */
public interface ExaminationMapper {
    /**
     * 查询该班级是否参与过某科目的考试
     * 同学期不可能出现相同的科目考试
     * 学期 班级id 科目id 相同 此班级此学期已经安排了此课
     * list.size()大于0 无法新增考务
     * @param clazzId
     * @param subjectId
     * @return
     */
    @Select("SELECT * FROM examination " +
            "WHERE clazz_id = #{clazzId} " +
            "AND semester = #{semester}" +
            "AND subject_Id = #{subjectId} " +
            "AND is_deleted = false ")
    List<Examination> selectExaminationByClazzIdAndSubject(Long clazzId, Long subjectId,String semester);


    /**
     * 此学期考完了 考务的数据被删除了 依旧不可以新增考务
     * list.size()大于0 无法新增考务
     * @param clazzId
     * @param subjectId
     * @return
     */
    @Select("SELECT * FROM examination " +
            "WHERE clazz_id = #{clazzId} " +
            "AND semester = #{semester}" +
            "AND subject_Id = #{subjectId} " +
            "AND is_deleted = true " +
            "AND is_join = true")
    List<Examination> selectExaminationByClazzIdAndSubject1(Long clazzId, Long subjectId,String semester);

//    /**
//     * 查询是否有时间冲突
//     * @param startTime
//     * @param finishTime
//     * @return
//     */
//    @Select("SELECT * FROM examination WHERE " +
//            "start_time BETWEEN #{startTime} AND #{finishTime} ")
//    List<Examination> selectExaminationByTime(Timestamp startTime, Timestamp finishTime);


    /**
     * 根据班级id和学期查询考务数据
     * @param semester
     * @param clazzId
     * @return
     */
    @Select("SELECT * FROM examination WHERE semester = #{semester} AND clazz_id = #{clazzId}")
    List<Examination> getExaminationBySemesterAndClazzId(String semester,Long clazzId);
}

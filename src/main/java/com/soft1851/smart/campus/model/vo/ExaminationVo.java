package com.soft1851.smart.campus.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * @author xunmi
 * @ClassName ExaminationDto
 * @Description TODO
 * @Date 2020/6/3
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExaminationVo {

    /**
     * 主键，
     */
    private Long pkExaminationId;

    /**
     * 学期
     */
    private String semester;

    /**
     * 监考老师
     */
    private String teacherName;

    /**
     * 开始时间
     */
    private Timestamp startTime;

    /**
     * 地点
     */
    private String area;

    /**
     * 试卷分数
     */
    private Integer score;

    /**
     * 考试类型
     */
    private String type;

    /**
     * 创建时间
     */
    private Timestamp gmtCreate;

    /**
     * 科目名
     */
    private String subjectName;

    /**
     * 班级姓名
     */
    private String clazzName;

}
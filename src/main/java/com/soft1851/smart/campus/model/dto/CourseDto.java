package com.soft1851.smart.campus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 新增课程信息
 * @Author wf
 * @Date 2020/6/18
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private String jobNumber;
    private String name;
    private Long roomId;
    private Long towerId;
    private Long semesterName;
}

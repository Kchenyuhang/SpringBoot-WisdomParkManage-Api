package com.soft1851.smart.campus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryDto {
    private Object field;
    private String filed1;
    private Boolean status;
}

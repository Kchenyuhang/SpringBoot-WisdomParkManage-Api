package com.soft1851.smart.campus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName BatchDeletionDto
 * @Description TODO
 * @date 2020-06-12 10:16
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatchDeletionDto {
    private String ids;
}

package com.soft1851.smart.campus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName PageDto
 * @Description TODO
 * @date 2020-05-26 15:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDto {
    private int currentPage;
    private int pageSize;
}

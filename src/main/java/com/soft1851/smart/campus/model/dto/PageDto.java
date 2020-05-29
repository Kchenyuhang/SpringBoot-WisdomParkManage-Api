package com.soft1851.smart.campus.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 * @version 1.0
 * @ClassName PageDto
 * @Description TODO
 * @date 2020-05-26 15:55
 **/
@Data
@Builder
public class PageDto {
    private Object field;
    private int currentPage;
    private int pageSize;
}

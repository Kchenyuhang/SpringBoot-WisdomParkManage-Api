package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.FleaCommentDto;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaGoodsService.java
 * @Description TODO
 * @createTime 2020年06月09日 13:58:00
 */
public interface FleaCommentService {
    /**
     * 新增评论
     * @param commentDto
     * @return
     */
    ResponseResult addComment(FleaCommentDto commentDto);
}

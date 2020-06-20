package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;

/**
 * @author Tao
 */
public interface SysSubjectService {
    /**
     * 模糊查询学科
     * @param keywords
     * @return
     */
    ResponseResult getSubjectLike(String keywords);

}

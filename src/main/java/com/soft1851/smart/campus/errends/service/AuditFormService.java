package com.soft1851.smart.campus.errends.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.errends.domain.dto.AuditFormDto;

/**
 * @author wl
 * @ClassNameAuditFormService
 * @Description TODO
 * @Date 2020/6/17
 * @Version 1.0
 */
public interface AuditFormService {
    /**
     * 审核跑腿
     * @param auditFormDto
     * @return
     */
    ResponseResult saveAuditForm(AuditFormDto auditFormDto);
}

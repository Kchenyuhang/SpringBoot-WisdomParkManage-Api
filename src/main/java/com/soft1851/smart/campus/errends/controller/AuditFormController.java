package com.soft1851.smart.campus.errends.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.errends.domain.dto.AuditFormDto;
import com.soft1851.smart.campus.errends.service.AuditFormService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wl
 * @ClassNameAuditFormController
 * @Description TODO
 * @Date 2020/6/17
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "errends")
@Api(value = "review", tags = "跑腿申请")
public class AuditFormController {
    @Resource
    private AuditFormService auditFormService;

    @PostMapping(value="/Errends")
    public ResponseResult becomeErrends(@RequestBody AuditFormDto auditFormDto) {
        return auditFormService.saveAuditForm(auditFormDto);
    }
}

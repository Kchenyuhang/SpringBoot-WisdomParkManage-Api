package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BatchDeletionDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.SingleParam;
import com.soft1851.smart.campus.model.dto.UpdateSysStatementDto;
import com.soft1851.smart.campus.model.entity.SysStatement;
import com.soft1851.smart.campus.service.SysStatementService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysStatementController
 * @Description TODO
 * @date 2020-06-02 13:46
 **/
@RestController
@RequestMapping(value = "/statement")
@Api(value = "SysStatementController", tags = "声明管理接口")
public class SysStatementController {
    @Resource
    private SysStatementService sysStatementService;

    /**
     * 分页查询所有声明
     * @param pageDto
     * @return
     */
    @PostMapping(value = "/all")
    ResponseResult findAllStatement(@RequestBody PageDto pageDto){
        return sysStatementService.findAllStatement(pageDto);
    }

    /**
     * 新增声明
     * @param sysStatement
     * @return
     */
    @PostMapping(value = "/increase")
    public ResponseResult increaseSysStatement(@RequestBody SysStatement sysStatement){
        return sysStatementService.increaseSysStatement(sysStatement);
    }

    /**
     * 修改声明
     * @param updateSysStatementDto
     * @return
     */
    @PutMapping(value = "/modification")
    public ResponseResult modificationSysStatement(@RequestBody UpdateSysStatementDto updateSysStatementDto){
        return sysStatementService.modificationSysStatement(updateSysStatementDto);
    }


    /**
     * 删除声明
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deletion/{id}")
    public ResponseResult deletedSysStatement(@PathVariable Long id){
        return sysStatementService.deletionSysStatement(id);
    }


    /**
     * 批量删除声明
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/deletionBath/{ids}")
    public ResponseResult deletedBatch(@PathVariable String ids){
        return sysStatementService.deletedBatch(ids);
    }


    /**
     * 逻辑删除声明
     * @param singleParam
     * @return
     */
    @DeleteMapping(value = "/deletion")
    public ResponseResult deleteSysStatement(@RequestBody SingleParam singleParam){
        return sysStatementService.deleteSysStatement(singleParam.getPkId());
    }

    /**
     * 批量逻辑删除声明
     * @param batchDeletionDto
     * @return
     */
    @PostMapping(value = "/deletionBath")
    public ResponseResult deletedBatch(@RequestBody BatchDeletionDto batchDeletionDto){
        return sysStatementService.deleteBatchByPkStatementId(batchDeletionDto.getIds());
    }


}
package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.InfoType;
import com.soft1851.smart.campus.service.InfoTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Yujie_Zhao
 * @ClassName InfoTypeController
 * @Description 资讯分类Controller层
 * @Date 2020/6/3  8:52
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/infoType")
@Api(value = "InfoTypeController",tags = {"资讯分类接口"})
public class InfoTypeController {
    @Resource
    private InfoTypeService infoTypeService;

    /**
     * 查找所有资讯
     * @return List<InfoManage>
     */
    @ApiOperation(value = "查询资讯分类",notes = "")
    @GetMapping(value = "/all")
    public ResponseResult findInfoType(){
        return infoTypeService.findAllInfoType();
    }

    /**
     * 添加资讯分类
     * @param infoType
     * @return
     */
    @ApiOperation(value = "添加资讯分类",notes = "")
    @PostMapping(value = "/insert")
    public ResponseResult insertInfoType(@RequestBody InfoType infoType){
        return infoTypeService.insertInfoType(infoType);
    }

    /**
     * 删除资讯分类
     * @param id
     * @return
     */
    @ApiOperation(value = "删除资讯分类",notes = "")
    @DeleteMapping(value = "/deletion/{id}")
    public ResponseResult deleteInfoType(@PathVariable Long id){
        return infoTypeService.deleteInfoType(id);
    }

    /**
     * 批量删除咨询
     * @return
     */
    @ApiOperation(value = "批量删除咨询分类",notes = "")
    @DeleteMapping(value = "/deletionBath/{ids}")
    public ResponseResult deletedBatch(@PathVariable String ids){
        return infoTypeService.deletedBatch(ids);
    }

    /**
     * 修改资讯分类
     * @param infoType
     * @return
     */
    @ApiOperation(value = "修改资讯分类",notes = "")
    @PutMapping(value = "/modification")
    public ResponseResult updateInfoType(@RequestBody InfoType infoType){
        return infoTypeService.updateInfoType(infoType);
    }

}

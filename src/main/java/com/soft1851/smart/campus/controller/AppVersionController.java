package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BatchDeletionDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.SingleParam;
import com.soft1851.smart.campus.model.dto.UpdateAppVersionDto;
import com.soft1851.smart.campus.model.entity.AppVersion;
import com.soft1851.smart.campus.service.AppVersionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName AppVersionController
 * @Description TODO
 * @date 2020-06-05 9:15
 **/
@RestController
@RequestMapping("/app")
@Api(value = "AppVersionController", tags = "App版本管理接口")
public class AppVersionController {
    @Resource
    private AppVersionService appVersionService;

    /**
     * 分页查询所有声明
     *
     * @param pageDto
     * @return
     */
    @PostMapping(value = "/all")
    ResponseResult findAllAppVersion(@RequestBody PageDto pageDto) {
        return appVersionService.findAllAppVersion(pageDto);
    }

    /**
     * 修改版本数据信息
     *
     * @param updateAppVersionDto
     * @return
     */
    @PostMapping(value = "/modification")
    public ResponseResult updateAppVersion(@RequestBody UpdateAppVersionDto updateAppVersionDto) {
        return appVersionService.modificationAppVersion(updateAppVersionDto);
    }

    /**
     * 新增版本信息
     *
     * @param appVersion
     * @return
     */
    @PostMapping(value = "/increase")
    public ResponseResult increaseAppVersion(@RequestBody AppVersion appVersion) {
        return appVersionService.increaseAppVersion(appVersion);
    }

    /**
     * 逻辑删除版本信息
     *
     * @param singleParam
     * @return
     */
    @PostMapping(value = "/deletion")
    public ResponseResult deleteAppVersion(@RequestBody SingleParam singleParam) {
        return appVersionService.deletionAppVersion(singleParam.getPkId());
    }

    /**
     * 批量逻辑删除反馈
     *
     * @param batchDeletionDto
     * @return
     */
    @PostMapping(value = "/deletionBath")
    public ResponseResult deletedBatch(@RequestBody BatchDeletionDto batchDeletionDto) {
        return appVersionService.deletedBatch(batchDeletionDto.getIds());
    }


}

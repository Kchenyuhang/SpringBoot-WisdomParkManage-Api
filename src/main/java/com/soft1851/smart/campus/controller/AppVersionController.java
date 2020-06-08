package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.service.AppVersionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class AppVersionController {
    @Resource
    private AppVersionService appVersionService;

    /**
     * 分页查询所有声明
     * @param pageDto
     * @return
     */
    @PostMapping(value = "/all")
    ResponseResult findAllStatement(@RequestBody PageDto pageDto){
        return appVersionService.findAllAppVersion(pageDto);
    }
}

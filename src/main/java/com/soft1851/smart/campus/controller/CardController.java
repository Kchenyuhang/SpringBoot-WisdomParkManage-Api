package com.soft1851.smart.campus.controller;


import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName CardController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/26
 **/
@Slf4j
@RestController
public class CardController {
    @Resource
    private CardService service;
    /**
     * 查询所有消息
     * @param pageDto
     * @return
     */
//    @ApiOperation(value = "查询所有",notes = "请求参数为当前页和页面条数")
    @PostMapping("/card/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto){
        return service.findAllByPage(pageDto);
    }

}
package com.soft1851.smart.campus.controller;


import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysCard;
import com.soft1851.smart.campus.service.CardService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "查询所有",notes = "请求参数为当前页和页面条数")
    @PostMapping("/card/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto){
        return service.findAllByPage(pageDto);
    }

    /**
     * 修改一卡通信息
     * @param sysCard
     * @return
     */
    @ApiOperation(value = "修改一卡通信息数据",notes = "请求参数为卡号、卡密、绑定账号" +
            "、余额、状态")
    @PutMapping("/card/modification")
    ResponseResult updateCard (@RequestBody SysCard sysCard){
        return service.updateCard(sysCard);
    }

    /**
     * 删除一卡通信息
     * @param pkCardId
     * @return
     */
    @ApiOperation(value = "删除一卡通信息数据",notes = "请求参数为Id")
    @GetMapping("/card/deletion/{pk_card_id}")
    ResponseResult deleteCard(@RequestParam ("pk_card_id") Long pkCardId){
        return service.deleteCard(pkCardId);
    }

}
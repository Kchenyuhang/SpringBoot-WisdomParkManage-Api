package com.soft1851.smart.campus.controller;


import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysCard;
import com.soft1851.smart.campus.service.CardService;
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
    @PostMapping("/card/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto){
        return service.findAllByPage(pageDto);
    }

    /**
     * 修改一卡通信息
     * @param sysCard
     * @return
     */
    @PutMapping("/card/modification")
    ResponseResult updateCard (@RequestBody SysCard sysCard){
        return service.updateCard(sysCard);
    }

    /**
     * 删除一卡通信息
     * @param pkCardId
     * @return
     */
    @GetMapping("/card/deletion/{pk_card_id}")
    ResponseResult deleteCard(@RequestParam ("pk_card_id") Long pkCardId){
        return service.deleteCard(pkCardId);
    }

    /**
     * 单个增加一卡通信息
     * @param sysCard
     * @return
     */
    @PostMapping("/card/increase")
    ResponseResult saveCard(@RequestBody SysCard sysCard){
        return service.insert(sysCard);
    }



}
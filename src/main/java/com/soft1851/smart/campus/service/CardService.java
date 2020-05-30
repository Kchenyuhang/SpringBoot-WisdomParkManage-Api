package com.soft1851.smart.campus.service;


import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysCard;

import java.util.List;

/**
 * @ClassName CardService
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/26
 **/
public interface CardService {
    /**
     * 分页查询一卡通数据
     * @param pageDto
     * @return
     */
    ResponseResult findAllByPage(PageDto pageDto);

    /**
     * 批量增加一卡通信息
     * @return
     * @param sysCards
     */
    ResponseResult insertAll(List<SysCard> sysCards);


}
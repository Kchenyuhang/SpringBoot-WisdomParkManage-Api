package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.*;
import com.soft1851.smart.campus.model.entity.FleaGoods;
import org.springframework.data.domain.Page;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaGoodsService.java
 * @Description TODO
 * @createTime 2020年06月09日 13:58:00
 */
public interface FleaGoodsService {

    /**
     * 根据时间分页查询商品
     *
     * @return
     */
    ResponseResult getGoodsByTime(PageDto pageDto);


    /**
     * 根据商品ID删除商品
     *
     * @param pkGoodsId
     * @return
     */
    ResponseResult logical(Long pkGoodsId);

    /**
     * 批量逻辑删除
     *
     * @param fleaRewardBatchIdDto
     * @return ResponseResult
     */
    ResponseResult batchLogicalDel(FleaRewardBatchIdDto fleaRewardBatchIdDto);

    /**
     * 查询top前五的标签
     *
     * @return ResponseResult
     */
    ResponseResult findTopFiveMark();
}

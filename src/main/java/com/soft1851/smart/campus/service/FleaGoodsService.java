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
     * 模糊查询所有商品
     */
    Page<FleaGoods> findFleaGoodsByContent(FleaSearchDto fleaSearchDto);

    /**
     * 根据时间分页查询商品
     *
     * @return
     */
    ResponseResult getGoodsByTime(PageDto pageDto);

    /**
     * 根据商品id查询指定商品信息；
     *
     * @param goodIdDto GoodIdDto
     * @return ResponseResult
     */
    ResponseResult findGoodById(GoodIdDto goodIdDto);

    /**
     * 修改商品
     *
     * @param fleaGoodsDto FleaGoodsDto
     * @return ResponseResult
     */
    ResponseResult updateGood(FleaGoodsDto fleaGoodsDto);

    /**
     * 下架商品
     *
     * @param soldOutGoodDto SoldOutGoodDto
     * @return ResponseResult
     */
    ResponseResult soldOutGood(SoldOutGoodDto soldOutGoodDto);

    /**
     * 添加商品
     *
     * @param saveGoodDto SaveGoodDto
     * @return ResponseResult
     */
    ResponseResult saveGoods(SaveGoodDto saveGoodDto);

    /**
     * 查询top前五的标签
     *
     * @return ResponseResult
     */
    ResponseResult findTopFiveMark();
}

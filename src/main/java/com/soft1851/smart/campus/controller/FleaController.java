package com.soft1851.smart.campus.controller;


import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.*;
import com.soft1851.smart.campus.model.entity.FleaGoods;
import com.soft1851.smart.campus.model.entity.FleaReward;
import com.soft1851.smart.campus.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaController.java
 * @Description TODO
 * @createTime 2020年06月09日 14:37:00
 */
@Slf4j
@RestController
@RequestMapping(value = "/flea/")
@Api(value = "FleaController", tags = {"跳蚤市场接口"})
public class FleaController {
    @Resource
    private FleaGoodsService fleaGoodsService;
    @Resource
    private FleaRewardService fleaRewardService;
    @Resource
    private FleaTypeService fleaTypeService;
    @Resource
    private FleaUserService fleaUserService;
    @Resource
    private FleaOrderService fleaOrderService;
    @Resource
    private FleaCollectionService fleaCollectionService;
    @Resource
    private FleaCommentService fleaCommentService;

    /**
     * 根据id删除单个悬赏
     *
     * @param fleaRewardIdDto FleaRewardIdDto
     * @return ResponseResult
     */
    @PostMapping(value = "reward/deleteOne")
    public ResponseResult deleteOneRewardById(@RequestBody FleaRewardIdDto fleaRewardIdDto) {
        return fleaRewardService.deleteOneById(fleaRewardIdDto);
    }

    /**
     * @param fleaRewardBatchIdDto FleaRewardBatchIdDto
     * @return ResponseResult
     */
    @PostMapping(value = "reward/batchDelete")
    public ResponseResult batchDeleteRewardById(@RequestBody FleaRewardBatchIdDto fleaRewardBatchIdDto) {
        return fleaRewardService.batchDeleteById(fleaRewardBatchIdDto);
    }

    /**
     * 逻辑删除单个订单
     *
     * @param fleaOrderDto FleaOrderDto
     * @return ResponseResult
     */
    @PostMapping(value = "order/logicalDelOne")
    public ResponseResult logicalDelOneOrder(@RequestBody FleaOrderDto fleaOrderDto) {
        return fleaOrderService.logicalDel(fleaOrderDto);
    }

    /**
     * 批量逻辑删除订单
     *
     * @param fleaOrderBatchIdDto FleaOrderBatchIdDto
     * @return ResponseResult
     */
    @PostMapping(value = "order/batchLogicalDel")
    public ResponseResult batchLogicalDelOrder(@RequestBody FleaOrderBatchIdDto fleaOrderBatchIdDto) {
        return fleaOrderService.batchLogicalDel(fleaOrderBatchIdDto);
    }
}

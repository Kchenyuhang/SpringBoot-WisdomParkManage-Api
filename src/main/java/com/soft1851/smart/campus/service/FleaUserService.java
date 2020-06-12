package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.FleaUserDto;
import com.soft1851.smart.campus.model.dto.FleaUserIdDto;
import com.soft1851.smart.campus.model.dto.UpdateFleaUserDto;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaGoodsService.java
 * @Description TODO
 * @createTime 2020年06月09日 13:58:00
 */
public interface FleaUserService {

    /**
     * 添加用户数据
     *
     * @param fleaUserDto FleaUserDto
     * @return ResponseResult
     */
    ResponseResult saveFleaUser(FleaUserDto fleaUserDto);

    /**
     * 用户数据修改
     *
     * @param updateFleaUserDto UpdateFleaUserDto
     * @return ResponseResult
     */
    ResponseResult updateFleaUser(UpdateFleaUserDto updateFleaUserDto);

    /**
     * 根据用户id查询该用户发布的商品
     *
     * @param fleaUserIdDto FleaUserIdDto
     * @return ResponseResult
     */
    ResponseResult findGoodsByUserId(FleaUserIdDto fleaUserIdDto);

    /**
     * 根据用户id查询该用户的商品订单
     *
     * @param fleaUserIdDto FleaUserIdDto
     * @return ResponseResult
     */
    ResponseResult findOrderByUserId(FleaUserIdDto fleaUserIdDto);
}

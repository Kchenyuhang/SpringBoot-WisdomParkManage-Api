package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.entity.Tower;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/1
 * @Version 1.0
 */
public interface TowerService {

    /**
     * 查询所有楼栋信息
     * @return
     */
    List<Tower> findAll();

    /**
     * 新增楼栋信息
     */
    void insertTower(Tower tower);

    /**
     * 根据id删除楼栋信息
     */
    void deleteTowerById(long towerId);

    /**
     * 根据id修改楼栋信息
     * @param tower
     */
    void updateTowerByTowerId(Tower tower);
}

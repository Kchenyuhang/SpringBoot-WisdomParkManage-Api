package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.Tower;
import com.soft1851.smart.campus.service.TowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/2
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/tower")
@Api(value = "TowerController", tags = "楼栋用户管理接口")
public class TowerController {
    @Resource
    private TowerService towerService;

    @ApiOperation(value = "获取所有楼栋信息")
    @GetMapping(value = "/list")
    public List<Tower> selectAll() {
        return towerService.findAll();
    }

    @PostMapping("/increase")
    public ResponseResult insert(@RequestBody Tower tower) {
        towerService.insertTower(tower);
        return ResponseResult.success();
    }

    @PutMapping("/single")
    public ResponseResult updateByTowerId(@RequestBody Tower tower) {
        towerService.updateTowerByTowerId(tower);
        return ResponseResult.success();
    }

    @DeleteMapping("/id/{id}")
    public ResponseResult deleteByTowerId(@PathVariable int id) {
        towerService.deleteTowerById(id);
        return ResponseResult.success();
    }
}
package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.Room;
import com.soft1851.smart.campus.model.vo.TowerVo;
import com.soft1851.smart.campus.service.RoomService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/3
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/room")
@Api(value = "RoomController" ,tags = "房间接口")
public class RoomController {
    @Resource
    private RoomService roomService;

    @GetMapping(value = "/list")
    public List<TowerVo> selectAll() {
        return roomService.selectAll();
    }

    @PostMapping
    public ResponseResult insertRoom(@RequestBody Room room) {
        roomService.insertRoom(room);
        return ResponseResult.success();
    }

    @PutMapping("/id")
    public ResponseResult updateRoomById(@RequestBody Room room) {
        roomService.update(room);
        return ResponseResult.success();
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseResult deleteRoomById(@PathVariable int id) {
        roomService.deleteRoomById(id);
        return ResponseResult.success();
    }
}


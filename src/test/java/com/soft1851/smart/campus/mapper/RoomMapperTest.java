package com.soft1851.smart.campus.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/18
 * @Version 1.0
 */
@SpringBootTest
class RoomMapperTest {
    @Resource
    private RoomMapper roomMapper;

    @Test
    void getRoomTowerByTowerId() {
        System.out.println(roomMapper.getRoomTowerByRoomId(1));
    }
}
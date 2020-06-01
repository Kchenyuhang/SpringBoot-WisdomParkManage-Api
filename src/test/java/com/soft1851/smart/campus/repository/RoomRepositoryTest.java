package com.soft1851.smart.campus.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomRepositoryTest {

    @Resource
    private RoomRepository roomRepository;

    @Test
    void getRoomName() {
        System.out.println(roomRepository.getRoomName(1L));
    }
}
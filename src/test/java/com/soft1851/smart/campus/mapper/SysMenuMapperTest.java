package com.soft1851.smart.campus.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/14
 * @Version 1.0
 */
@SpringBootTest
class SysMenuMapperTest {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Test
    public void test() {
        System.out.println(sysMenuMapper.getParentMenu());
    }
}
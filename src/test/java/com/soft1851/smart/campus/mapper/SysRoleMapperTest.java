package com.soft1851.smart.campus.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SysRoleMapperTest {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Test
    void getAllSysRole() throws SQLException {
        List<Map> sysRoleList = sysRoleMapper.getAllSysRole();
        System.out.println(sysRoleList);
    }
}
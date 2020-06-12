package com.soft1851.smart.campus.service;

import com.soft1851.smart.campus.model.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName FleaUserServiceTest.java
 * @Description TODO
 * @createTime 2020年06月12日 14:56:00
 */
@SpringBootTest
class FleaUserServiceTest {
    @Resource
    private FleaUserService fleaUserService;
    @Test
    void findAllUser() {
        PageDto pageDto = new PageDto();
        pageDto.setCurrentPage(0);
        pageDto.setPageSize(3);
        System.out.println(fleaUserService.findAllUser(pageDto));
    }
}
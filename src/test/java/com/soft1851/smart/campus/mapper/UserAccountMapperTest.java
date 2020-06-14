package com.soft1851.smart.campus.mapper;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.vo.UserAccountVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class UserAccountMapperTest {

    @Resource
    private UserAccountMapper userAccountMapper;
    @Test
    void getUserAccountVo() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(3)
                .build();
        List<UserAccountVo> userAccountVos = userAccountMapper.getUserAccountVo(pageDto);
        System.out.println(userAccountVos);
    }
}
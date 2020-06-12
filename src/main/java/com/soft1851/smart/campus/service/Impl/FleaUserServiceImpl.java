package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.FleaUserDto;
import com.soft1851.smart.campus.model.dto.FleaUserIdDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.UpdateFleaUserDto;
import com.soft1851.smart.campus.model.entity.FleaUser;
import com.soft1851.smart.campus.model.entity.UserAccount;
import com.soft1851.smart.campus.repository.FleaUserRepository;
import com.soft1851.smart.campus.repository.UserAccountRepository;
import com.soft1851.smart.campus.service.FleaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/6/12
 */
@Slf4j
@Service
public class FleaUserServiceImpl implements FleaUserService {
    @Resource
    private FleaUserRepository fleaUserRepository;

    @Override
    public ResponseResult findAllUser(PageDto pageDto) {
        Pageable pageable = PageRequest.of(pageDto.getCurrentPage(), pageDto.getPageSize());
        Page<FleaUser> all = fleaUserRepository.findAll(pageable);
        return ResponseResult.success(all);
    }
}

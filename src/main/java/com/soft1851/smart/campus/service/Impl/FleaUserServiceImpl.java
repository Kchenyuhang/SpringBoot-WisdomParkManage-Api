package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.*;
import com.soft1851.smart.campus.model.entity.FleaUser;
import com.soft1851.smart.campus.model.entity.UserAccount;
import com.soft1851.smart.campus.repository.FleaUserRepository;
import com.soft1851.smart.campus.repository.UserAccountRepository;
import com.soft1851.smart.campus.service.FleaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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

    @Override
    public ResponseResult findUserByContent(FleaSearchDto fleaSearchDto) {
        String content = fleaSearchDto.getContent();
        List<FleaUser>  users = fleaUserRepository.findFleaUsersByNicknameLikeOrUsernameLikeOrPhoneNumberLikeOrSexLikeOrJobNumberLike("%" + content + "%", "%" + content + "%", "%" + content + "%", "%" + content + "%", "%" + content + "%");
        Pageable pageable = PageRequest.of(fleaSearchDto.getCurrentPage(), fleaSearchDto.getPageSize());
        Page<FleaUser> fleaUsers = new PageImpl<FleaUser>(users, pageable,users.size());
        return ResponseResult.success(fleaUsers);
    }
}

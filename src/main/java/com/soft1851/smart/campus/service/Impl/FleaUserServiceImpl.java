package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.FleaUserDto;
import com.soft1851.smart.campus.model.dto.FleaUserIdDto;
import com.soft1851.smart.campus.model.dto.UpdateFleaUserDto;
import com.soft1851.smart.campus.model.entity.FleaUser;
import com.soft1851.smart.campus.model.entity.UserAccount;
import com.soft1851.smart.campus.repository.FleaUserRepository;
import com.soft1851.smart.campus.repository.UserAccountRepository;
import com.soft1851.smart.campus.service.FleaUserService;
import lombok.extern.slf4j.Slf4j;
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
    @Resource
    private UserAccountRepository userAccountRepository;

    @Override
    public ResponseResult saveFleaUser(FleaUserDto fleaUserDto) {
        FleaUser fleaUserVos = fleaUserRepository.findAllByJobNumber(fleaUserDto.getJobNumber());
        if (fleaUserVos == null) {
            Optional<UserAccount> userAccountOptional = userAccountRepository.findByCardNumber(fleaUserDto.getJobNumber());
            FleaUser fleaUser = FleaUser.builder()
                    .nickname(userAccountOptional.get().getNickname()).username(userAccountOptional.get().getUserName())
                    .sex(userAccountOptional.get().getGender()).phoneNumber(userAccountOptional.get().getPhoneNumber())
                    .jobNumber(userAccountOptional.get().getJobNumber()).avatar(userAccountOptional.get().getAvatar())
                    .isDeleted(false)
                    .build();
            fleaUserRepository.save(fleaUser);
            return ResponseResult.success("用户数据添加成功");
        } else {
            return ResponseResult.success(fleaUserVos);
        }
    }

    @Override
    public ResponseResult updateFleaUser(UpdateFleaUserDto updateFleaUserDto) {
        Optional<FleaUser> fleaUserOptional = fleaUserRepository.findById(updateFleaUserDto.getPkFleaUserId());
        FleaUser fleaUser = FleaUser.builder()
                .isDeleted(fleaUserOptional.get().getIsDeleted()).jobNumber(fleaUserOptional.get().getJobNumber())
                .avatar(updateFleaUserDto.getAvatar()).phoneNumber(updateFleaUserDto.getPhoneNumber())
                .username(fleaUserOptional.get().getUsername()).nickname(updateFleaUserDto.getNickname())
                .sex(updateFleaUserDto.getSex()).pkFleaUserId(updateFleaUserDto.getPkFleaUserId())
                .build();
        fleaUserRepository.saveAndFlush(fleaUser);
        return ResponseResult.success("用户数据修改成功");
    }

    @Override
    public ResponseResult findGoodsByUserId(FleaUserIdDto fleaUserIdDto) {
        Pageable pageable = PageRequest.of(fleaUserIdDto.getCurrentPage() - 1, fleaUserIdDto.getPageSize());
        return ResponseResult.success(fleaUserRepository.selectGoodsByUserId(fleaUserIdDto.getPkFleaUserId(), pageable));
    }

    @Override
    public ResponseResult findOrderByUserId(FleaUserIdDto fleaUserIdDto) {
        Pageable pageable = PageRequest.of(fleaUserIdDto.getCurrentPage() - 1, fleaUserIdDto.getPageSize());
        return ResponseResult.success(fleaUserRepository.selectOrOrdersByUserId(fleaUserIdDto.getPkFleaUserId(), pageable));
    }
}

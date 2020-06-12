package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.FleaCommentDto;
import com.soft1851.smart.campus.model.entity.FleaComment;
import com.soft1851.smart.campus.repository.FleaCommentRepository;
import com.soft1851.smart.campus.repository.FleaRewardRepository;
import com.soft1851.smart.campus.repository.FleaUserRepository;
import com.soft1851.smart.campus.service.FleaCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/6/12
 */
@Slf4j
@Service
public class FleaCommentServiceImpl implements FleaCommentService {
    @Autowired
    private FleaCommentRepository commentRepository;
    @Autowired
    private FleaUserRepository userRepository;
    @Autowired
    private FleaRewardRepository rewardRepository;
    @Override
    public ResponseResult addComment(FleaCommentDto commentDto) {
        FleaComment fleaComment = FleaComment.builder()
                .comment(commentDto.getComment())
                .commentBy(userRepository.getOne(commentDto.getUserId()))
                .reviewer(userRepository.getOne(commentDto.getReviewerId()))
                .createTime(Timestamp.valueOf(LocalDateTime.now()))
                .fleaReward(rewardRepository.getOne(commentDto.getRewardId()))
                .isDeleted(false)
                .build();
        commentRepository.save(fleaComment);
        return ResponseResult.success("成功");
    }
}

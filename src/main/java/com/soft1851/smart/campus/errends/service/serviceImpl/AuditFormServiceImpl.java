package com.soft1851.smart.campus.errends.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.errends.domain.dto.AuditFormDto;
import com.soft1851.smart.campus.errends.domain.entity.AuditForm;
import com.soft1851.smart.campus.errends.domain.entity.ReviewForm;
import com.soft1851.smart.campus.errends.domain.entity.Transaction;
import com.soft1851.smart.campus.errends.mapper.DeliveryOrderMapper;
import com.soft1851.smart.campus.errends.mapper.ReviwFormMapper;
import com.soft1851.smart.campus.errends.mapper.TransactionMapper;
import com.soft1851.smart.campus.errends.repository.AuditFormRepository;
import com.soft1851.smart.campus.errends.service.AuditFormService;
import com.soft1851.smart.campus.errends.util.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wl
 * @ClassNameAuditFormServiceImpl
 * @Description TODO
 * @Date 2020/6/16
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
@Slf4j
public class AuditFormServiceImpl implements AuditFormService {
    @Resource
    private AuditFormRepository auditFormRepository;
    @Resource
    private ReviwFormMapper reviwFormMapper;
    @Resource
    private DeliveryOrderMapper deliveryOrderMapper;
    @Resource
    private TransactionMapper transactionMapper;

    @Override
    public ResponseResult saveAuditForm(AuditFormDto auditFormDto) {
        SnowFlake snowFlake = new SnowFlake(1, 3);
        long id = snowFlake.nextId();
        AuditForm auditForm = AuditForm.builder()
                .endTime(Timestamp.valueOf(LocalDateTime.now()))
                .founderId(auditFormDto.getFounderId()).gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now())).id(String.valueOf(id)).isDeleted(false)
                .remark(auditFormDto.getRemark()).reviewerId(auditFormDto.getReviewerId()).stauts(auditFormDto.getStauts())
                .build();
        auditFormRepository.save(auditForm);
        //更改申请表状态
        QueryWrapper<ReviewForm> queryWrapper = new QueryWrapper();
        queryWrapper.eq("requester_id", auditFormDto.getReviewerId());
        ReviewForm reviewForm = ReviewForm.builder().status(1L).build();
        reviwFormMapper.update(reviewForm, queryWrapper);
        return ResponseResult.success();


    }

    @Override
    public ResponseResult selectErrends(AuditFormDto auditFormDto) {
        //查询申请表中数据  查询所有跑腿
        QueryWrapper<ReviewForm> reviewFormQueryWrapper = new QueryWrapper<>();
        reviewFormQueryWrapper.eq("status", auditFormDto.getStauts());
        List<ReviewForm> reviewForms = reviwFormMapper.selectList(reviewFormQueryWrapper);
        if (reviewForms.size() != 0) {
            for (ReviewForm reviewForm : reviewForms) {
                QueryWrapper<Transaction> transactionQueryWrapper = new QueryWrapper<>();
                transactionQueryWrapper.eq("errands_id", reviewForm.getRequesterId());


            }

            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);

        }


        return null;
    }
}

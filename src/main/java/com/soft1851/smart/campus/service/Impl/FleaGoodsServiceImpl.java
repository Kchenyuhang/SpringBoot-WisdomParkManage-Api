package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.*;
import com.soft1851.smart.campus.model.entity.FleaGoods;
import com.soft1851.smart.campus.repository.FleaGoodsRepository;
import com.soft1851.smart.campus.repository.FleaTypeRepository;
import com.soft1851.smart.campus.repository.FleaUserRepository;
import com.soft1851.smart.campus.service.FleaGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/6/12
 */
@Slf4j
@Service
public class FleaGoodsServiceImpl implements FleaGoodsService {
    @Resource
    private FleaGoodsRepository fleaGoodsRepository;
    @Resource
    private FleaUserRepository fleaUserRepository;
    @Resource
    private FleaTypeRepository fleaTypeRepository;

    @Override
    public ResponseResult getGoodsByTime(PageDto pageDto) {
        Pageable pageable = PageRequest.of(pageDto.getCurrentPage() - 1, pageDto.getPageSize(), Sort.Direction.DESC, "goodsCreateTime");
        if (fleaGoodsRepository.getAllGoodsByTime(pageable).size() == 0) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success(fleaGoodsRepository.getAllGoodsByTime(pageable));

    }

    @Override
    public ResponseResult logical(Long pkGoodsId) {
        return ResponseResult.success(fleaGoodsRepository.soldOutGood(pkGoodsId));
    }

    @Override
    public ResponseResult batchLogicalDel(FleaRewardBatchIdDto fleaRewardBatchIdDto) {
        int n = fleaGoodsRepository.batchLogicalDel(fleaRewardBatchIdDto.getId());
        return ResponseResult.success("成功删除" + n + "条数据");
    }


}

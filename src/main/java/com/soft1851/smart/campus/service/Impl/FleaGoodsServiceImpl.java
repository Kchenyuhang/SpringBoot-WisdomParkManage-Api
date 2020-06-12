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
    public Page<FleaGoods> findFleaGoodsByContent(FleaSearchDto fleaSearchDto) {
        //创建分页构建器   按照时间降序排序
        Pageable pageable = PageRequest.of(fleaSearchDto.getCurrentPage(), fleaSearchDto.getPageSize(), Sort.Direction.DESC, "goodsCreateTime");
        //根据内容模糊搜索
        List<FleaGoods> result = fleaGoodsRepository.findFleaGoodsByGoodsNameLikeOrGoodsDescriptionLike("%" + fleaSearchDto.getContent() + "%", "%" + fleaSearchDto.getContent() + "%");
        Page<FleaGoods> fleaGoodsInfo = new PageImpl<FleaGoods>(result, pageable, result.size());
        return fleaGoodsInfo;
    }


    @Override
    public ResponseResult getGoodsByTime(PageDto pageDto) {
        Pageable pageable = PageRequest.of(pageDto.getCurrentPage(), pageDto.getPageSize(), Sort.Direction.DESC, "goodsCreateTime");
        if (fleaGoodsRepository.getAllGoodsByTime(pageable).size() == 0) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success(fleaGoodsRepository.getAllGoodsByTime(pageable));

    }

    @Override
    public ResponseResult findGoodById(GoodIdDto goodIdDto) {
        return ResponseResult.success(fleaGoodsRepository.selectGoodsById(goodIdDto.getPkFleaGoodsId()));
    }

    @Override
    public ResponseResult updateGood(FleaGoodsDto fleaGoodsDto) {
        Optional<FleaGoods> fleaGoodsOptional = fleaGoodsRepository.findById(fleaGoodsDto.getPkFleaGoodsId());
        FleaGoods fleaGoods1 = FleaGoods.builder()
                .pkFleaGoodsId(fleaGoodsDto.getPkFleaGoodsId()).goodsName(fleaGoodsDto.getGoodsName())
                .goodsDescription(fleaGoodsDto.getGoodsDescription()).goodsImgUrl(fleaGoodsDto.getGoodsImgUrl())
                .goodsPrice(fleaGoodsDto.getGoodsPrice()).goodsCreateTime(fleaGoodsOptional.get().getGoodsCreateTime())
                .fleaType(fleaTypeRepository.findById(fleaGoodsDto.getPkFleaTypeId()).get())
                .fleaUser(fleaUserRepository.findById(fleaGoodsDto.getPkFleaUserId()).get())
                .goodsMark(fleaGoodsDto.getGoodsMark()).isDeleted(fleaGoodsOptional.get().getIsDeleted())
                .build();
        fleaGoodsRepository.saveAndFlush(fleaGoods1);
        return ResponseResult.success("商品信息修改成功");
    }

    @Override
    public ResponseResult soldOutGood(SoldOutGoodDto soldOutGoodDto) {
        fleaGoodsRepository.soldOutGood(soldOutGoodDto.getPkFleaGoodsId());
        return ResponseResult.success("商品下架成功");
    }

    @Override
    public ResponseResult saveGoods(SaveGoodDto saveGoodDto) {
        FleaGoods fleaGoods = FleaGoods.builder()
                .fleaType(fleaTypeRepository.findById(saveGoodDto.getPkFleaTypeId()).get())
                .fleaUser(fleaUserRepository.findById(saveGoodDto.getPkFleaUserId()).get())
                .goodsName(saveGoodDto.getGoodsName()).goodsDescription(saveGoodDto.getGoodsDescription())
                .goodsImgUrl(saveGoodDto.getGoodsImgUrl()).goodsPrice(saveGoodDto.getGoodsPrice())
                .goodsMark(saveGoodDto.getGoodsMark()).goodsCreateTime(Timestamp.valueOf(LocalDateTime.now()))
                .isDeleted(false)
                .build();
        fleaGoodsRepository.save(fleaGoods);
        return ResponseResult.success("商品添加成功");
    }

    @Override
    public ResponseResult findTopFiveMark() {
        return ResponseResult.success(fleaGoodsRepository.selectTopFiveMark());
    }
}

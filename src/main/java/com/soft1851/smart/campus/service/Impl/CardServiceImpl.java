package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysCard;
import com.soft1851.smart.campus.repository.CardRepository;
import com.soft1851.smart.campus.service.CardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CardServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/26
 **/
@Service
public class CardServiceImpl implements CardService {
    @Resource
   private CardRepository cardRepository;

    @Override
    public ResponseResult findAllByPage(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkCardId");
        Page<SysCard> sysCards = cardRepository.findAll(pageable);
        return ResponseResult.success(sysCards.getContent());
    }

    @Override
    public ResponseResult insertAll(List<SysCard> sysCards) {
        List<SysCard> sysCardList=cardRepository.saveAll(sysCards);
        return ResponseResult.success(sysCardList);
    }

    @Override
    public ResponseResult deleteCard(Long pkCardId) {
        cardRepository.deleteByPkCardId(pkCardId);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult updateCard(SysCard sysCard) {
        SysCard card=cardRepository.findByPkCardId(sysCard.getPkCardId());
        if (card.getStatus()){
            card.setCardPassword(sysCard.getCardPassword());
            card.setJobNumber(sysCard.getJobNumber());
            card.setCardBalance(sysCard.getCardBalance());
           cardRepository.saveAndFlush(card);
            return ResponseResult.success(card);
        }
        return ResponseResult.failure(ResultCode.DATABASE_ERROR);
    }

    @Override
    public ResponseResult insert(SysCard sysCard) {
        SysCard addCard=cardRepository.save(sysCard);
        return ResponseResult.success(addCard);
    }
}
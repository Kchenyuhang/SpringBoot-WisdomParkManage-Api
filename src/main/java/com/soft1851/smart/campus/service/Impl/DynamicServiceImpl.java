package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.DynamicDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Dynamic;
import com.soft1851.smart.campus.repository.DynamicRepository;
import com.soft1851.smart.campus.service.DynamicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName DynamicServiceImpl
 * @Description 校友圈动态资讯
 * @Date 2020/6/12  15:28
 * @Version 1.0
 **/
@Service
public class DynamicServiceImpl implements DynamicService {

    @Resource
    private DynamicRepository dynamicRepository;

    /**
     * 添加动态资讯
     * @param dynamicDto
     * @return
     */
    @Override
    public ResponseResult insertDynamic(DynamicDto dynamicDto) {
        Dynamic dynamic = Dynamic.builder()
                .type(dynamicDto.getType())
                .content(dynamicDto.getContent())
                .userId(dynamicDto.getUserId())
                .build();
        return ResponseResult.success(dynamicRepository.save(dynamic));
    }

    /**
     * 批量查找动态资讯
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult findAllDynamic(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkDynamicId");
        Page<Dynamic> dynamicPage = dynamicRepository.findAll(pageable);
        return ResponseResult.success(dynamicPage.getContent());
    }

    /**
     * 删除单个动态
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteDynamic(String id) {
        //根据id查询角色数据是否存在 ，若存在进行删除，不存则返回 数据有误
        Dynamic dynamic = dynamicRepository.findDynamicByPkDynamicIdAndIsDeleted(id,false);
        if (dynamic != null) {
            dynamic.setIsDeleted(true);
            dynamicRepository.saveAndFlush(dynamic);
            return ResponseResult.success("删除成功");
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 批量删除动态
     * @param ids
     * @return
     */
    @Override
    public ResponseResult deletedBatch(List<String> ids) {
        int a = dynamicRepository.updateIsDelete(ids);
        if(a>0){
            return ResponseResult.success("删除成功");
        }else {
            return ResponseResult.success(ResultCode.DATABASE_ERROR);
        }

    }

    /**
     * 修改动态信息
     * @param dynamic
     * @return
     */
    @Override
    public ResponseResult updateDynamic(Dynamic dynamic) {
        return null;
    }
}

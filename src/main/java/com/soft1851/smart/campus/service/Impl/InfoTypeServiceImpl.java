package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.entity.InfoType;
import com.soft1851.smart.campus.repository.InfoTypeRepository;
import com.soft1851.smart.campus.service.InfoTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yujie_Zhao
 * @ClassName InfoTypeServiceImpl
 * @Description TODO
 * @Date 2020/6/2  15:28
 * @Version 1.0
 **/
@Service
public class InfoTypeServiceImpl implements InfoTypeService {

    @Resource
    private InfoTypeRepository infoTypeRepository;

    /**
     * 查询所有资讯分类
     * @return
     */
    @Override

    public ResponseResult findAllInfoType() {
        List<InfoType> infoTypeList = infoTypeRepository.findAll();
        return ResponseResult.success(infoTypeList);
    }

    /**
     * 新增资讯分类
     * @param infoType
     * @return
     */
    @Override
    public ResponseResult insertInfoType(InfoType infoType) {
        InfoType infoType1 = infoTypeRepository.findTopByOrderBySortDesc();

        infoType.setSort(infoType1.getSort()+1);
        infoType.setIsDeleted(true);
        infoTypeRepository.save(infoType);
        if (infoType.getPkInfoTypeId()!=null){
            return ResponseResult.success("添加成功");
        }
        else {
            return ResponseResult.success(ResultCode.DATABASE_ERROR);
        }
    }

    /**
     * 分类删除
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteInfoType(Long id) {
        InfoType infoType = infoTypeRepository.findByPkInfoTypeId(id);
        if (infoType!=null){
            infoTypeRepository.deleteById(id);
            return ResponseResult.success("删除成功");
        }
        return ResponseResult.success(ResultCode.DATABASE_ERROR);
    }

    @Override
    public ResponseResult deletedBatch(String ids) {
        //判断是否有数据
        if (ids.length() != 0) {
            //将接收到的ids字符串，使用逗号分割
            String[] idArr = ids.split(",");
            List<Long> idsList = new ArrayList<Long>();
            for (String id : idArr) {
                //遍历所有id存入到list
                idsList.add(Long.valueOf(id));
            }
            infoTypeRepository.deleteBatch(idsList);
            return ResponseResult.success("删除成功");
        } else {
            return ResponseResult.failure(ResultCode.PARAM_IS_BLANK);
        }
    }

    /**
     * 修改资讯分类
     * @param infoType
     * @return
     */
    @Override
    public ResponseResult updateInfoType(InfoType infoType) {
        InfoType infoType1 = infoTypeRepository.findByPkInfoTypeId(infoType.getPkInfoTypeId());
        if (infoType1!= null){
            infoType1.setName(infoType.getName());
            infoType1.setSort(infoType.getSort());
            infoType1.setGmtCreate(infoType1.getGmtCreate());
            infoType1.setIsDeleted(true);
            infoTypeRepository.saveAndFlush(infoType1);
            return ResponseResult.success("修改成功"+infoType1);
        }
        return ResponseResult.success(ResultCode.DATABASE_ERROR);
    }
}

package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.TypeDto;
import com.soft1851.smart.campus.model.entity.FleaType;
import com.soft1851.smart.campus.repository.FleaTypeRepository;
import com.soft1851.smart.campus.service.FleaTypeService;
import com.soft1851.smart.campus.utils.TreeBuilder;
import com.soft1851.smart.campus.utils.TreeNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/6/12
 */
@Slf4j
@Service
public class FleaTypeServiceImpl implements FleaTypeService {
    @Resource
    private FleaTypeRepository fleaTypeRepository;

    @Override
    public Map<String, Object> findAllType() {
        Map<String, Object> map = new TreeMap<>();
//        List<TreeNode> list = new ArrayList<>();
//        //查找所有的type
//        List<FleaType> types = fleaTypeRepository.findAll();
//        for (FleaType fleaType : types) {
//            //如果没有父节点
//            if (fleaType.getParentId() == 0) {
//                TreeNode treeNode = new TreeNode(fleaType.getPkFleaTypeId(), 0L, fleaType.getTypeName(), fleaType.getTypeCoverUrl(), fleaType.getTypeUrl(), new ArrayList<>());
//                list.add(treeNode);
//            } else {
//                TreeNode treeNode = new TreeNode(fleaType.getPkFleaTypeId(), fleaType.getParentId(), fleaType.getTypeName(), fleaType.getTypeCoverUrl(), fleaType.getTypeUrl(), new ArrayList<>());
//                list.add(treeNode);
//            }
//        }
//        List<TreeNode> trees = TreeBuilder.buildTreeByLoop(list);
//        map.put("types", trees);
        return map;
    }

    @Override
    public ResponseResult getGoodsByType(TypeDto typeDto) {
        Pageable pageable = PageRequest.of(typeDto.getCurrentPage(), typeDto.getPageSize(), Sort.Direction.DESC, "goodsCreateTime");
        if (fleaTypeRepository.getGoodsByTypeId(pageable, typeDto).size() == 0) {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return ResponseResult.success(fleaTypeRepository.getGoodsByTypeId(pageable, typeDto));
    }
}

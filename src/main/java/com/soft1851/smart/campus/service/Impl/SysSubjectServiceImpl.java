package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.mapper.SysSubjectMapper;
import com.soft1851.smart.campus.model.vo.SysSubjectVo;
import com.soft1851.smart.campus.service.SysSubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysSubjectServiceImpl
 * @Description TODO
 * @date 2020-06-19 11:24
 **/
@Service
public class SysSubjectServiceImpl implements SysSubjectService {
    @Resource
    private SysSubjectMapper sysSubjectMapper;

    @Override
    public ResponseResult getSubjectLike(String keywords) {
        List<SysSubjectVo> mapList = null;
        try {
            mapList = sysSubjectMapper.findSubjectLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseResult.success(mapList);
    }
}

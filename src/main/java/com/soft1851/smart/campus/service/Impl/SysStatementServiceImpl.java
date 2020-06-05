package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysStatement;
import com.soft1851.smart.campus.repository.SysStatementRepository;
import com.soft1851.smart.campus.service.SysStatementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysStatementServiceImpl
 * @Description TODO
 * @date 2020-06-02 10:34
 **/
@Service
public class SysStatementServiceImpl implements SysStatementService {
    @Resource
    private SysStatementRepository sysStatementRepository;

    /**
     * 分页查询所有声明数据
     *
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult findAllStatement(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkStatementId");
        Page<SysStatement> statementPage = sysStatementRepository.findAll(pageable);
        return ResponseResult.success(statementPage.getContent());
    }

    @Override
    public ResponseResult increaseSysStatement(SysStatement sysStatement) {
        if (sysStatement.getStatementContent().length() != 0 &&
                sysStatement.getStatementTitle().length() != 0 &&
                sysStatement.getStatementType().length() != 0) {
            SysStatement sysStatement1 = SysStatement.builder()
                    .statementType(sysStatement.getStatementType())
                    .statementTitle(sysStatement.getStatementTitle())
                    .statementContent(sysStatement.getStatementContent())
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(false)
                    .build();
            sysStatementRepository.save(sysStatement1);
            return ResponseResult.success();
        }else {
            return ResponseResult.failure(ResultCode.PARAM_NOT_COMPLETE);
        }
    }

    @Override
    public ResponseResult modificationSysStatement(SysStatement sysStatement) {
        SysStatement sysStatement1 = sysStatementRepository.findSysStatementByPkStatementId(sysStatement.getPkStatementId());
        if (sysStatement1!=null){
            if (sysStatement.getStatementType()!=null){
                sysStatement1.setStatementType(sysStatement.getStatementType());
            }
            if (sysStatement.getStatementTitle()!=null){
                sysStatement1.setStatementTitle(sysStatement.getStatementTitle());
            }
            if (sysStatement.getStatementContent() !=null){
                sysStatement1.setStatementContent(sysStatement.getStatementContent());
            }
            sysStatementRepository.saveAndFlush(sysStatement1);
            return ResponseResult.success(sysStatement1);
        }else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public ResponseResult deletionSysStatement(Long sysPkSysStatement) {
        SysStatement sysStatement1 = sysStatementRepository.findSysStatementByPkStatementId(sysPkSysStatement);
        if (sysStatement1!=null){
            sysStatementRepository.deleteByPkStatementId(sysPkSysStatement);
            return ResponseResult.success();
        }else {
           return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
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
            sysStatementRepository.deleteBatch(idsList);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.PARAM_IS_BLANK);
        }
    }
}

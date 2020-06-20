package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.model.vo.EntityVo;
import com.soft1851.smart.campus.service.ExaminationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xunmi
 * @ClassName ExaminationController
 * @Description 考务控制器
 * @Date 2020/5/31
 * @Version 1.0
 **/
@RestController
@RequestMapping("/examination")
@Api(value = "ExaminationController" ,tags = "考务管理接口")
public class ExaminationController {

    @Resource
    private ExaminationService examinationService;

    @PostMapping("/modification")
    public void updateInfo(@RequestBody Examination examination) {
        examinationService.updateInfo(examination);
    }

    /**
     * 新增考务
     * @param examination
     * @return
     */
    @ApiOperation(value = "新增考务",notes = "")
    @PostMapping(value = "/increase")
    public ResponseResult increaseSysFeedback(@RequestBody Examination examination){
        return examinationService.increaseInfo(examination);
    }

    @PostMapping("/all/page")
    public List<EntityVo> findAllByPage(@RequestBody PageDto pageDto) {
        // 首先排除前端传过来的参数出现 第0页 和 第 ‘负数’ 页的情况
        if (pageDto.getCurrentPage() < 1) {
            pageDto.setCurrentPage(1);
        }
        /*
         重新计算参数值，实现分页效果
         LIMIT 始终设定为 pageSize
         OFFSET 计算公式为： pageSize * (currentPage - 1)
         */
        pageDto.setCurrentPage(pageDto.getPageSize() * (pageDto.getCurrentPage() - 1));
        return examinationService.findAllByPage(pageDto);
    }

    /**
     * 统计出考务数据的总量接口
     *
     * @return
     */
    @PostMapping("/count")
    public Long totalNum() {
        return examinationService.countNum();
    }
}

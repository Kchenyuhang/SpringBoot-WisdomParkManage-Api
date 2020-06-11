package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.SysFeedback;
import com.soft1851.smart.campus.service.SysFeedbackService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName sysFeedbackController
 * @Description TODO
 * @date 2020-06-02 23:22
 **/
@RestController
@RequestMapping(value = "/feedback")
@Api(value = "SysFeedbackController", tags = "反馈管理接口")
public class SysFeedbackController {
    @Resource
    private SysFeedbackService sysFeedbackService;


    /**
     * 分页查询所有反馈
     * @param pageDto
     * @return
     */
    @PostMapping(value = "/all")
    ResponseResult findAllSysFeedback(@RequestBody PageDto pageDto){
        return sysFeedbackService.findAllSysFeedback(pageDto);
    }

    /**
     * 新增反馈
     * @param sysFeedback
     * @return
     */
    @PostMapping(value = "/increase")
    public ResponseResult increaseSysFeedback(@RequestBody SysFeedback sysFeedback){
        return sysFeedbackService.increaseSysFeedback(sysFeedback);
    }

    /**
     * 修改反馈
     * @param sysFeedback
     * @return
     */
    @PutMapping(value = "/modification")
    public ResponseResult modificationSysFeedback(@RequestBody SysFeedback sysFeedback){
        return sysFeedbackService.modificationSysFeedback(sysFeedback);
    }


    /**
     * 删除反馈
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deletion/{id}")
    public ResponseResult deletedSysFeedback(@PathVariable Long id){
        return sysFeedbackService.deletionSysFeedback(id);
    }


    /**
     * 批量删除反馈
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/deletionBath/{ids}")
    public ResponseResult deletedBatch(@PathVariable String ids){
        return sysFeedbackService.deletedBatch(ids);
    }

}

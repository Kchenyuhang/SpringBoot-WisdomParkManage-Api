package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.dto.BorrowDto;
import com.soft1851.smart.campus.model.dto.BorrowInsertDto;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.dto.UpdateBorrowDto;
import com.soft1851.smart.campus.service.SysBorrowService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/6/3 12:56
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping(value = "/borrow")
@Api(value = "SysBorrowController", tags = "借阅记录管理接口")
public class SysBorrowController {
    @Resource
    private SysBorrowService sysBorrowService;

    @PostMapping("/all")
    ResponseResult findAllByPage(@RequestBody PageDto pageDto) {
        return sysBorrowService.findAllByPage(pageDto);
    }
    /**
     * 根据时间查询
     * @param borrowDto
     * @return
     */
    @PostMapping("/time")
    ResponseResult getBorrowByTime(@RequestBody BorrowDto borrowDto) {
        log.info(">>>>>>>>>>>>>>>" + borrowDto);
        return sysBorrowService.getBorrowByTime(borrowDto);
    }


    /**
     * 添加借阅信息
     * @param borrowInsertDto
     * @return
     */
    @PostMapping("/increase")
    ResponseResult borrowInsert(@RequestBody BorrowInsertDto borrowInsertDto) {
        return sysBorrowService.borrowInsert(borrowInsertDto);
    }

    /**
     * 修改借阅状态
     * @param updateBorrowDto
     * @return
     */
    @PostMapping(value = "/deletion")
    public ResponseResult deleteSysFeedback(@RequestBody UpdateBorrowDto updateBorrowDto){
        return sysBorrowService.deletedSysRole(updateBorrowDto.getId(),updateBorrowDto.getIsDeleted());
    }
}

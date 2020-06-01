package com.soft1851.smart.campus.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Description 传来的图书
 * @Author 涛涛
 * @Date 2020/6/1 8:25
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysBookDto {
    /**
     * 作者
     */
    @NotNull
    private String author;
    /**
     * 封面
     */
    @NotNull
    private String cover;
    /**
     * 类型
     */
    @NotNull
    private String type;
    /**
     * 简介
     */
    @NotNull
    private String description;
    /**
     * 书名
     */
    @NotNull
    private String bookName;

    @NotNull
    private int bookNumber;
}

package com.soft1851.smart.campus.model.dto;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/25
 * @Version 1.0
 */
@Entity
@Data
public class InfoType {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkInfoTypeId;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 排序字段
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Timestamp gmtCreate;

    /**
     * 更新时间
     */
    @Column(name = "gmt_modified")
    private Timestamp gmtModified;

    /**
     * 删除标志（0 未删除， 1 已删除）
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}

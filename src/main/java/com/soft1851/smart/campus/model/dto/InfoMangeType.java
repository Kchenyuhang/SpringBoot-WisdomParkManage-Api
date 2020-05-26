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
@Table(name = "info_manage_type", indexes = {@Index(name = "type_idIndex", columnList = "type_id")})
public class InfoMangeType {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkInfoManageTypeId;

    /**
     * 资讯类型id
     */
    @Column(name = "type_id")
    private Long typeId;

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
     * 删除标志（0 未删除， 1 逻辑删除）
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}

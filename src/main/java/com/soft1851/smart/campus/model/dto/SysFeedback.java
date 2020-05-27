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
public class SysFeedback {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkFeedbackId;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 联系方式
     */
    @Column(name = "contact_way")
    private String contactWay;

    /**
     * 处理状态（0 未处理， 1 已处理）
     */
    @Column(name = "is_handled")
    private Boolean isHandled;

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

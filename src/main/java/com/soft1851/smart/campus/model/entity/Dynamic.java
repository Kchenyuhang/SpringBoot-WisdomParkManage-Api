package com.soft1851.smart.campus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName dynamic
 * @Description 动态
 * @Author xiaobinggan
 * @Date 2020/6/8 10:40 上午
 * @Version 1.0
 **/
@Table(name = "dynamic",
        indexes = {@Index(name = "titleIndex", columnList = "title")})
@Entity
public class Dynamic {

    /**
     * 主键，策略为自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkDynamicId;

    /**
     * 标题
     */
    @Column(name = "title", nullable = false, length = 20)
    private String title = "";

    /**
     * 内容
     */
    @Column(name = "content", nullable = false)
    private String content = "";

    /**
     * 点赞数
     */
    @Column(name = "thumbs", nullable = false)
    private Integer thumbs = 0;

    /**
     * 评论数
     */
    @Column(name = "comments", nullable = false)
    private Integer comments = 0;

    /**
     * 类型标签
     */
    @Column(name = "type", nullable = false)
    private String type = "";

    /**
     * 创建时间
     */
    //@JsonIgnore
    @Column(nullable = false)
    private Timestamp gmtCreate;

    /**
     * 修改时间
     */
    @JsonIgnore
    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp gmtModified;

    /**
     * 删除标志（0 逻辑删除， 1 未删除）
     */
//    @JsonIgnore
    @Column(nullable = false, length = 4)
    private Boolean isDeleted;


}

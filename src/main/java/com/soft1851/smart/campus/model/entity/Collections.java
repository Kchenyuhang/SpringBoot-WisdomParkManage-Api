package com.soft1851.smart.campus.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName Collection
 * @Description 收藏
 * @Author xiaobinggan
 * @Date 2020/6/8 12:51 下午
 * @Version 1.0
 **/
@Entity
@Table(name = "collection")
public class Collections {
    /**
     * 主键，策略为自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkCollectionId;

    /**
     * 动态id
     */
    @Column(name = "dynamic_id", nullable = false)
    private Long dynamicId;

    /**
     * 用户id
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

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

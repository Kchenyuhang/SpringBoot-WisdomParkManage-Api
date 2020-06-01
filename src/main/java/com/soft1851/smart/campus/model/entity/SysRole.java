package com.soft1851.smart.campus.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysRole
 * @Description TODO
 * @date 2020-05-31 14:23
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SysRole {
    //角色id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkRoleId;

    //角色名
    @Column(length = 32, nullable = false)
    private String roleName;

    //角色描述
    @Column(length = 32, nullable = false)
    private String roleDecoration;

    //排序字段
    @Column(length = 4, nullable = false)
    private Integer sort;


    //创建时间
    @Column(nullable = false)
    private Timestamp gmtCreate;

    //修改时间
    @Column(nullable = false)
    private Timestamp gmtModified;

    //是否删除（1 逻辑删除， 0 未删除）
    @Column(length = 4, nullable = false)
    private Boolean isDeleted;

}

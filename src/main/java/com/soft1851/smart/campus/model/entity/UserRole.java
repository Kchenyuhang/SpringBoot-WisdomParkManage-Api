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
 * @ClassName UserRole
 * @Description TODO
 * @date 2020-06-01 13:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserRole {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkRoleId;
    //用户id
    @Column(unique = true)
    private Long sysUserId;

    //角色id
    @Column(unique = true)
    private Long roleId;

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

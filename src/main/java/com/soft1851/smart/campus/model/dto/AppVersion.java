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
public class AppVersion {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkAppVersionId;

    /**
     * 当前的版本号
     */
    @Column(name = "current_version")
    private String currentVersion;

    /**
     * 最高版本号
     */
    @Column(name = "max_version")
    private String maxVersion;

    /**
     * 最低版本号
     */
    @Column(name = "min_version")
    private String minVersion;

    /**
     * 版本描述
     */
    @Column(name = "version_description")
    private String versionDescription;

    /**
     * 下载地址
     */
    @Column(name = "download_link")
    private String downloadLink;


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

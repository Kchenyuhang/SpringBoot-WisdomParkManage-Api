package com.soft1851.smart.campus.utils;

import com.soft1851.smart.campus.model.entity.SysCourse;

import java.sql.Timestamp;

/**
 * @author xunmi
 * @ClassName DateUtil
 * @Description 有关时间操作的工具类
 * @Date 2020/6/1
 * @Version 1.0
 **/
public class DateUtil {

    /**
     * 获取当前时间（Timestamp）
     * @return
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

}

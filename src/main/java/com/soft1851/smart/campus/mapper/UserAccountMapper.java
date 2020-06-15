package com.soft1851.smart.campus.mapper;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.UserAccount;
import com.soft1851.smart.campus.model.vo.UserAccountVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserAccountMapper
 * @Description TODO
 * @date 2020-06-14 13:03
 **/
public interface UserAccountMapper {
    /**
     * 分页查询所有学生数据
     * @param pageDto
     * @return
     */
    @Select("SELECT u.pk_user_account_id,u.gender,u.gmt_create,u.is_deleted,u.job_number,u.phone_number," +
            "u.status,u.user_name,c.name " +
            "FROM user_account u " +
            "LEFT JOIN clazz c " +
            "ON u.clazz_id = c.pk_clazz_id " +
            "WHERE u.role = 1 AND u.is_deleted = false " +
            "LIMIT ${pageDto.pageSize*(pageDto.currentPage-1)},#{pageDto.pageSize}")
    List<UserAccountVo> getUserAccountVo(@Param("pageDto") PageDto pageDto);


    /**
     * 分页查询所有教师数据
     * @param pageDto
     * @return
     */
    @Select("SELECT u.pk_user_account_id,u.gender,u.gmt_create,u.is_deleted,u.job_number,u.phone_number," +
            "u.status,u.user_name,c.name " +
            "FROM user_account u " +
            "LEFT JOIN clazz c " +
            "ON u.clazz_id = c.pk_clazz_id " +
            "WHERE u.role = 2 AND u.is_deleted = false " +
            "LIMIT ${pageDto.pageSize*(pageDto.currentPage-1)},#{pageDto.pageSize}")
    List<UserAccountVo> getTeacherUserAccountVo(@Param("pageDto") PageDto pageDto);

    /**
     * 通过教工号查询用户数据
     * @param jobNumber
     * @return
     */
    @Select("SELECT * FROM user_account WHERE job_number = #{jobNumber} AND is_deleted = false")
    UserAccount getUserAccountByJobNumber(String jobNumber);
}

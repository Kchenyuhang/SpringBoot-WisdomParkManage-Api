package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.entity.SysRole;
import com.soft1851.smart.campus.repository.SysRoleRepository;
import com.soft1851.smart.campus.service.SysRoleService;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysRoleServiceImpl
 * @Description TODO
 * @date 2020-05-31 14:58
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleRepository sysRoleRepository;

    /**
     * 查询所有角色数据
     *
     * @return
     */
    @Override
    public ResponseResult findAllSysRole() {
        return ResponseResult.success(sysRoleRepository.findAllRole());
    }

    /**
     * 删除单个角色信息
     *
     * @param id
     * @return
     */
    @Override
    public ResponseResult deletedSysRole(Long id) {
        //根据id查询角色数据是否存在 ，若存在进行删除，不存则返回 数据有误
        SysRole sysRole = sysRoleRepository.findByPkRoleId(id);
        if (sysRole != null) {
            sysRoleRepository.deleteById(id);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 批量删除数据
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseResult deletedBatch(String ids) {
        //判断是否有数据
        if (ids.length() != 0) {
            //将接收到的ids字符串，使用逗号分割
            String[] idArr = ids.split(",");
            List<Long> idsList = new ArrayList<Long>();
            for (String id : idArr) {
                //遍历所有id存入到list
                idsList.add(Long.valueOf(id));
            }
            sysRoleRepository.deleteBatch(idsList);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.PARAM_IS_BLANK);
        }
    }

    /**
     * 修改角色信息
     * @param sysRole
     * @return
     */
    @Override
    @LastModifiedDate
    public ResponseResult updateSysRole(SysRole sysRole) {
        //根据id查询该角色信息是否存在，不存在返回数据不存在状态码
        SysRole sysRole1 = sysRoleRepository.findByPkRoleId(sysRole.getPkRoleId());
        if (sysRole1 != null) {
            sysRole1.setRoleName(sysRole.getRoleName());
            sysRole1.setRoleDecoration(sysRole.getRoleDecoration());
            sysRole1.setIsDeleted(sysRole.getIsDeleted());
            sysRoleRepository.saveAndFlush(sysRole1);
            return ResponseResult.success(sysRole1);
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 新增
     * @param sysRole
     * @return
     */
    @Override
    public ResponseResult increaseSysRole(SysRole sysRole) {
       SysRole sysRole2 = sysRoleRepository.findTopByOrderBySortDesc();
        SysRole sysRole1 = SysRole.builder()
//                .pkRoleId()
                .roleName(sysRole.getRoleName())
                .roleDecoration(sysRole.getRoleDecoration())
                .isDeleted(false)
                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                .sort(sysRole2.getSort()+1)
                .build();
        sysRoleRepository.save(sysRole1);
        return ResponseResult.success();
    }

    @Override
    public ResponseResult updateSysRoleSort(String sortList) {
        // 将前端传过来的sortId字符串转换为数组形式
        // 这个sortList的形式为[3,2,1,4] 含义：Id为3的元素 sortId为1，Id为2的元素 sortId为2
        String[] sortArray = null;
        sortArray = sortList.split(",");
        //判断前端传过来的sortId是否有相同的数据
        HashSet<String> sortHashSet = new HashSet<>();
        for(int j = 0;j<sortArray.length;j++){
            sortHashSet.add(sortArray[j]);
        }
        //前端返回数据中无相同数据 为正确
        if (sortHashSet.size() == sortArray.length){
            for (int i=0;i<sortArray.length;i++){
                sysRoleRepository.updateSysRole(Long.parseLong(sortArray[i]),(i+1));
            }
            // 查询出所有角色数据
            List<SysRole> roles = sysRoleRepository.findAllRole();
            return ResponseResult.success(roles);
        } else {
          return ResponseResult.failure(ResultCode.DATA_IS_WRONG);
        }
    }
}

package com.soft1851.smart.campus.controller;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.model.entity.SysRole;
import com.soft1851.smart.campus.service.SysRoleService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysRoleController
 * @Description TODO
 * @date 2020-05-31 15:13
 **/
@RestController
@RequestMapping("/role")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 查询所有角色数据
     * @return
     */
    @GetMapping(value = "/all")
    public ResponseResult findAllSysRole(){
        return sysRoleService.findAllSysRole();
    }

    /**
     * 单个删除角色数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deletion/{id}")
    public ResponseResult deletedSysRole(@PathVariable Long id){
        return sysRoleService.deletedSysRole(id);
    }

    /**
     * 批量删除角色数据
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/deletionBath/{ids}")
    public ResponseResult deletedBatch(@PathVariable String ids){
        return sysRoleService.deletedBatch(ids);
    }

    /**
     * 修改角色信息
     * @param sysRole
     * @return
     */
    @PutMapping(value = "/modification")
    public ResponseResult updateSysRole(@RequestBody SysRole sysRole){
        return sysRoleService.updateSysRole(sysRole);
    }

    /**
     * 新增角色信息
     * @param sysRole
     * @return
     */
    @PostMapping(value = "/increase")
    public ResponseResult increaseSysRole(@RequestBody SysRole sysRole){
        return sysRoleService.increaseSysRole(sysRole);
    }

    /**
     * 修改排序id
     * @param sortList
     * @return
     */
    @PutMapping("/modification/sort")
    public ResponseResult modificationSort(@Param("sortList") String sortList){
        return sysRoleService.updateSysRoleSort(sortList);
    }
}

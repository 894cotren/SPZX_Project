package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.SysRoleMapper;
import com.awc20.spzx.manager.service.SysRoleService;
import com.awc20.spzx.model.dto.system.SysRoleDto;
import com.awc20.spzx.model.entity.system.SysRole;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public PageInfo<SysRole> getSysRoleListByPage(Integer pageNum, Integer pageSize, SysRoleDto sysRoleDto) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysRole> sysRoleList = sysRoleMapper.selectSysRoleListByPage(sysRoleDto);
        PageInfo<SysRole> pageInfo=new PageInfo<>(sysRoleList);
        return pageInfo;
    }

    @Override
    public void saveSysRole(SysRole sysRole) {
        //这里应该有一个角色是否存在查询的判断吧。

        sysRoleMapper.insertSysRole(sysRole);
    }


    @Override
    public void updateSysRole(SysRole sysRole) {
        sysRoleMapper.updateSysRole(sysRole);
    }
}

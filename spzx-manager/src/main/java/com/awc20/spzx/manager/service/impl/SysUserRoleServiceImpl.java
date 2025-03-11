package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.manager.mapper.SysUserRoleMapper;
import com.awc20.spzx.manager.service.SysUserRoleService;
import com.awc20.spzx.model.dto.system.AssginRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public void doAssign(AssginRoleDto assginRoleDto) {
        //找之前先根据ID删除中间表绑定的信息再批量插入。
        sysUserRoleMapper.deleteByUserId(assginRoleDto.getUserId());
        //插入数据
        sysUserRoleMapper.insertUserRole(assginRoleDto);

    }
}

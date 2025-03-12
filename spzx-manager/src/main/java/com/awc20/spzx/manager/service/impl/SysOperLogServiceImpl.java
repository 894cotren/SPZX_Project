package com.awc20.spzx.manager.service.impl;

import com.awc20.spzx.common.log.service.SysOperLogService;
import com.awc20.spzx.manager.mapper.SysOperLogMapper;
import com.awc20.spzx.model.entity.order.SysOperLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysOperLogServiceImpl implements SysOperLogService {

    @Autowired
    SysOperLogMapper sysOperLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void saveSysOperLog(SysOperLog sysOperLog) {
        sysOperLogMapper.insertSysOperLog(sysOperLog);
    }
}

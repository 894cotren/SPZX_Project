package com.awc20.spzx.model.vo.system;

import com.awc20.spzx.model.entity.system.SysUser;

//这是一个本地线程存储用户数据的工具类。
public class SysUserThreadLocalAuthContextUtil {

    private static final ThreadLocal <SysUser> sysUserThreadLocal = new ThreadLocal<>();

    // 定义存储数据的静态方法
    public static void set(SysUser sysUser) {
        sysUserThreadLocal.set(sysUser);
    }

    // 定义获取数据的方法
    public static SysUser get() {
        return sysUserThreadLocal.get() ;
    }

    // 删除数据的方法
    public static void remove() {
        sysUserThreadLocal.remove();
    }
}

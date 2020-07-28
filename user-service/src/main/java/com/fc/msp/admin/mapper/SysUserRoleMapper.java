package com.fc.msp.admin.mapper;

import com.fc.msp.admin.entity.SysUserRole;
import tk.mybatis.mapper.common.Mapper;

/**
    *@ClassName SysUserRoleMapper
    *@Description TODO
    *@Author fangcheng
    *@Date 2020/7/28 1:21 下午
    *@Version 1.0
    */
public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}
package com.fc.msp.mspmail.mapper;

import com.fc.msp.mspmail.entity.SysUserRole;

public interface SysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}
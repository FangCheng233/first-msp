package com.fc.msp.admin.mapper;

import com.fc.msp.admin.entity.SysPermission;
import com.fc.msp.admin.entity.SysRole;
import tk.mybatis.mapper.common.Mapper;

/**
    *@ClassName SysRoleMapper
    *@Description TODO
    *@Author fangcheng
    *@Date 2020/7/28 1:20 下午
    *@Version 1.0
    */
public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}
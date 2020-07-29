package com.fc.msp.mspmail.mapper;

import com.fc.msp.mspmail.entity.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer menuid);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}
package com.fc.msp.admin.mapper;

import com.fc.msp.admin.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 *@ClassName SysMenuMapper
 *@Description TODO
 *@Author fangcheng
 *@Date 2020/7/28 12:59 下午
 *@Version 1.0
 */
@Mapper
public interface SysMenuMapper{

    int deleteByPrimaryKey(Integer menuid);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}
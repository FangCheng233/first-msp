package com.fc.msp.admin.mapper;

import com.fc.msp.admin.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

/**
 *@ClassName SysPermissionMapper
 *@Description TODO
 *@Author fangcheng
 *@Date 2020/7/28 1:15 下午
 *@Version 1.0
 */
@Mapper
public interface SysPermissionMapper  {

    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}
package com.fc.msp.admin.mapper;

import com.fc.msp.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *@ClassName UserMapper
 *@Description TODO
 *@Author fangcheng
 *@Date 2020/7/28 12:51 下午
 *@Version 1.0
 */
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
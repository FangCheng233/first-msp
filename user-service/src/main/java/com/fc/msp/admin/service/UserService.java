package com.fc.msp.admin.service;

import com.fc.msp.admin.entity.User;

public interface UserService {
    public int deleteByPrimaryKey(Integer id);

    public int insert(User record);

    public int insertSelective(User record);

    public User selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);
}

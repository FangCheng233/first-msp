package com.fc.msp.mspmail.entity;

import java.io.Serializable;
/**
 *@ClassName SysUserRole
 *@Description TODO
 *@Author fangcheng
 *@Date 2020/7/29 5:57 下午
 *@Version 1.0
 */
public class SysUserRole implements Serializable {
    private Integer userId;

    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
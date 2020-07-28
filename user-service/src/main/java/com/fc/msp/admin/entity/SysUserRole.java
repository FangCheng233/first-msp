package com.fc.msp.admin.entity;

import java.io.Serializable;

/**
    *@ClassName SysUserRole
    *@Description TODO
    *@Author fangcheng
    *@Date 2020/7/28 12:49 下午
    *@Version 1.0
    */

public class SysUserRole implements Serializable {
    private Integer userId;

    private Integer roleId;

    /**
     * Gets the value of userId. *
     *
     * @return the value of userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the userId. *
     * <p>You can use getUserId() to get the value of userId</p>
     * * @param userId userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the value of roleId. *
     *
     * @return the value of roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Sets the roleId. *
     * <p>You can use getRoleId() to get the value of roleId</p>
     * * @param roleId roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
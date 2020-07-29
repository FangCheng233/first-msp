package com.fc.msp.mspmail.entity;

import java.io.Serializable;
/**
 *@ClassName SysRole
 *@Description TODO
 *@Author fangcheng
 *@Date 2020/7/29 5:51 下午
 *@Version 1.0
 */
public class SysRole implements Serializable {
    private Integer roleid;

    private String rolename;

    private String roledesc;

    private String role;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc == null ? null : roledesc.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}
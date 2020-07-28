package com.fc.msp.admin.entity;


import java.io.Serializable;
/**
    *@ClassName SysRole
    *@Description TODO
    *@Author fangcheng
    *@Date 2020/7/28 12:51 下午
    *@Version 1.0
    */
public class SysRole implements Serializable {
    private Integer roleid;

    private String rolename;

    private String roledesc;

    private String role;

    /**
     * Gets the value of roleid. *
     *
     * @return the value of roleid
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * Sets the roleid. *
     * <p>You can use getRoleid() to get the value of roleid</p>
     * * @param roleid roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * Gets the value of rolename. *
     *
     * @return the value of rolename
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * Sets the rolename. *
     * <p>You can use getRolename() to get the value of rolename</p>
     * * @param rolename rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * Gets the value of roledesc. *
     *
     * @return the value of roledesc
     */
    public String getRoledesc() {
        return roledesc;
    }

    /**
     * Sets the roledesc. *
     * <p>You can use getRoledesc() to get the value of roledesc</p>
     * * @param roledesc roledesc
     */
    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    /**
     * Gets the value of role. *
     *
     * @return the value of role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role. *
     * <p>You can use getRole() to get the value of role</p>
     * * @param role role
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", roledesc='" + roledesc + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
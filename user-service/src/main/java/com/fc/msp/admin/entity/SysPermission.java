package com.fc.msp.admin.entity;
/**
    *@ClassName SysPermission
    *@Description TODO
    *@Author fangcheng
    *@Date 2020/7/28 12:47 下午
    *@Version 1.0
    */

import java.io.Serializable;

public class SysPermission implements Serializable {
    private Integer id;

    private String pdesc;

    private String name;

    private Integer menuid;

    /**
     * Gets the value of id. *
     *
     * @return the value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id. *
     * <p>You can use getId() to get the value of id</p>
     * * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the value of pdesc. *
     *
     * @return the value of pdesc
     */
    public String getPdesc() {
        return pdesc;
    }

    /**
     * Sets the pdesc. *
     * <p>You can use getPdesc() to get the value of pdesc</p>
     * * @param pdesc pdesc
     */
    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    /**
     * Gets the value of name. *
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name. *
     * <p>You can use getName() to get the value of name</p>
     * * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of menuid. *
     *
     * @return the value of menuid
     */
    public Integer getMenuid() {
        return menuid;
    }

    /**
     * Sets the menuid. *
     * <p>You can use getMenuid() to get the value of menuid</p>
     * * @param menuid menuid
     */
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", pdesc='" + pdesc + '\'' +
                ", name='" + name + '\'' +
                ", menuid=" + menuid +
                '}';
    }
}
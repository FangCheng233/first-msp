package com.fc.msp.mspmail.entity;

import java.io.Serializable;
/**
 *@ClassName SysPermission
 *@Description TODO
 *@Author fangcheng
 *@Date 2020/7/29 5:57 下午
 *@Version 1.0
 */
public class SysPermission implements Serializable {
    private Integer id;

    private String pdesc;

    private String name;

    private Integer menuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
}
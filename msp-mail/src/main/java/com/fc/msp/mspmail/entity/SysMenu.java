package com.fc.msp.mspmail.entity;

import java.io.Serializable;
/**
 *@ClassName SysMenu
 *@Description TODO
 *@Author fangcheng
 *@Date 2020/7/29 5:57 下午
 *@Version 1.0
 */
public class SysMenu implements Serializable {
    private Integer menuid;

    private Integer parentid;

    private String menuname;

    private String menuurl;

    private String menustatus;

    private Integer level;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }

    public String getMenustatus() {
        return menustatus;
    }

    public void setMenustatus(String menustatus) {
        this.menustatus = menustatus == null ? null : menustatus.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
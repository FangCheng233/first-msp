package com.fc.msp.mspmail.entity;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysMenu sysMenu = (SysMenu) o;
        return Objects.equals(menuid, sysMenu.menuid) &&
                Objects.equals(parentid, sysMenu.parentid) &&
                Objects.equals(menuname, sysMenu.menuname) &&
                Objects.equals(menuurl, sysMenu.menuurl) &&
                Objects.equals(menustatus, sysMenu.menustatus) &&
                Objects.equals(level, sysMenu.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuid, parentid, menuname, menuurl, menustatus, level);
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "menuid=" + menuid +
                ", parentid=" + parentid +
                ", menuname='" + menuname + '\'' +
                ", menuurl='" + menuurl + '\'' +
                ", menustatus='" + menustatus + '\'' +
                ", level=" + level +
                '}';
    }
}
package com.fc.msp.admin.entity;


import java.io.Serializable;
/**
    *@ClassName SysMenu
    *@Description TODO
    *@Author fangcheng
    *@Date 2020/7/28 12:51 下午
    *@Version 1.0
    */
public class SysMenu implements Serializable {
    private Integer menuid;

    private Integer parentid;

    private String menuname;

    private String menuurl;

    private String menustatus;

    private Integer level;

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

    /**
     * Gets the value of parentid. *
     *
     * @return the value of parentid
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * Sets the parentid. *
     * <p>You can use getParentid() to get the value of parentid</p>
     * * @param parentid parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * Gets the value of menuname. *
     *
     * @return the value of menuname
     */
    public String getMenuname() {
        return menuname;
    }

    /**
     * Sets the menuname. *
     * <p>You can use getMenuname() to get the value of menuname</p>
     * * @param menuname menuname
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    /**
     * Gets the value of menuurl. *
     *
     * @return the value of menuurl
     */
    public String getMenuurl() {
        return menuurl;
    }

    /**
     * Sets the menuurl. *
     * <p>You can use getMenuurl() to get the value of menuurl</p>
     * * @param menuurl menuurl
     */
    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }

    /**
     * Gets the value of menustatus. *
     *
     * @return the value of menustatus
     */
    public String getMenustatus() {
        return menustatus;
    }

    /**
     * Sets the menustatus. *
     * <p>You can use getMenustatus() to get the value of menustatus</p>
     * * @param menustatus menustatus
     */
    public void setMenustatus(String menustatus) {
        this.menustatus = menustatus;
    }

    /**
     * Gets the value of level. *
     *
     * @return the value of level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Sets the level. *
     * <p>You can use getLevel() to get the value of level</p>
     * * @param level level
     */
    public void setLevel(Integer level) {
        this.level = level;
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
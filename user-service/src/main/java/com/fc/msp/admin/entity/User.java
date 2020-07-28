package com.fc.msp.admin.entity;

import java.io.Serializable;
import java.util.Date;
/**
    *@ClassName User
    *@Description TODO
    *@Author fangcheng
    *@Date 2020/7/28 12:50 下午
    *@Version 1.0
    */
public class User implements Serializable {
    private Integer id;

    private String username;

    private String realName;

    private String avatarUrl;

    private String email;

    private String password;

    private String phoneNumber;

    private Date createTime;

    private Date updatedTime;

    private Integer locked;

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
     * Gets the value of username. *
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username. *
     * <p>You can use getUsername() to get the value of username</p>
     * * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the value of realName. *
     *
     * @return the value of realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * Sets the realName. *
     * <p>You can use getRealName() to get the value of realName</p>
     * * @param realName realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * Gets the value of avatarUrl. *
     *
     * @return the value of avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * Sets the avatarUrl. *
     * <p>You can use getAvatarUrl() to get the value of avatarUrl</p>
     * * @param avatarUrl avatarUrl
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * Gets the value of email. *
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email. *
     * <p>You can use getEmail() to get the value of email</p>
     * * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the value of password. *
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password. *
     * <p>You can use getPassword() to get the value of password</p>
     * * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the value of phoneNumber. *
     *
     * @return the value of phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phoneNumber. *
     * <p>You can use getPhoneNumber() to get the value of phoneNumber</p>
     * * @param phoneNumber phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the value of createTime. *
     *
     * @return the value of createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * Sets the createTime. *
     * <p>You can use getCreateTime() to get the value of createTime</p>
     * * @param createTime createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Gets the value of updatedTime. *
     *
     * @return the value of updatedTime
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * Sets the updatedTime. *
     * <p>You can use getUpdatedTime() to get the value of updatedTime</p>
     * * @param updatedTime updatedTime
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * Gets the value of locked. *
     *
     * @return the value of locked
     */
    public Integer getLocked() {
        return locked;
    }

    /**
     * Sets the locked. *
     * <p>You can use getLocked() to get the value of locked</p>
     * * @param locked locked
     */
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", createTime=" + createTime +
                ", updatedTime=" + updatedTime +
                ", locked=" + locked +
                '}';
    }
}
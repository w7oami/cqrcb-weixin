package com.model;

import java.util.Date;

public class GUser {
    private Long id;

    private String wxid;

    private String name;

    private String phone;

    private Long point;

    private Date createTime;

    private Date updateTime;

    private Integer gameCount;

    private Integer medalGetCount;

    private Integer medalActiveCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getGameCount() {
        return gameCount;
    }

    public void setGameCount(Integer gameCount) {
        this.gameCount = gameCount;
    }

    public Integer getMedalGetCount() {
        return medalGetCount;
    }

    public void setMedalGetCount(Integer medalGetCount) {
        this.medalGetCount = medalGetCount;
    }

    public Integer getMedalActiveCount() {
        return medalActiveCount;
    }

    public void setMedalActiveCount(Integer medalActiveCount) {
        this.medalActiveCount = medalActiveCount;
    }
}
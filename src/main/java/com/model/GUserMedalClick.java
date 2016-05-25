package com.model;

import java.util.Date;

public class GUserMedalClick {
    private Long id;

    private Long medalid;

    private String wxid;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedalid() {
        return medalid;
    }

    public void setMedalid(Long medalid) {
        this.medalid = medalid;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class GUserMedalClick {
    private Long id;

    private Long userMedalid;

    private String wxid;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserMedalid() {
        return userMedalid;
    }

    public void setUserMedalid(Long userMedalid) {
        this.userMedalid = userMedalid;
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
package com.easygame.sdk.repository.model.po;

import java.util.Date;

public class Channel {
    private Integer id;

    private String code;

    private String name;

    private Integer linkmanId;

    private Date creationDate;

    private Integer parentChannelId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLinkmanId() {
        return linkmanId;
    }

    public void setLinkmanId(Integer linkmanId) {
        this.linkmanId = linkmanId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getParentChannelId() {
        return parentChannelId;
    }

    public void setParentChannelId(Integer parentChannelId) {
        this.parentChannelId = parentChannelId;
    }
}
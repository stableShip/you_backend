package com.easygame.sdk.repository.model.po;

import java.util.Date;

public class ActiveRecord {
    private String imei;

    private String appKey;

    private Integer time;

    private String ip;

    private Long creationDateBiginttype;

    private Boolean dayType;

    private Date creationDateDatetype;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Long getCreationDateBiginttype() {
        return creationDateBiginttype;
    }

    public void setCreationDateBiginttype(Long creationDateBiginttype) {
        this.creationDateBiginttype = creationDateBiginttype;
    }

    public Boolean getDayType() {
        return dayType;
    }

    public void setDayType(Boolean dayType) {
        this.dayType = dayType;
    }

    public Date getCreationDateDatetype() {
        return creationDateDatetype;
    }

    public void setCreationDateDatetype(Date creationDateDatetype) {
        this.creationDateDatetype = creationDateDatetype;
    }
}
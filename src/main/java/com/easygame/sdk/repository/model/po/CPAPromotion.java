package com.easygame.sdk.repository.model.po;

import java.util.Date;

public class CPAPromotion {
    private Integer id;

    private String code;

    private Integer channelId;

    private String appKey;

    private Integer appId;

    private String appNickname;

    private Double sameDayPrice;

    private Double nextDayPrice;

    private Integer activeSameDayTime;

    private Integer activeNextDayTime;

    private Date lastUpdateDate;

    private Date creationDate;

    private Boolean isused;

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

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppNickname() {
        return appNickname;
    }

    public void setAppNickname(String appNickname) {
        this.appNickname = appNickname == null ? null : appNickname.trim();
    }

    public Double getSameDayPrice() {
        return sameDayPrice;
    }

    public void setSameDayPrice(Double sameDayPrice) {
        this.sameDayPrice = sameDayPrice;
    }

    public Double getNextDayPrice() {
        return nextDayPrice;
    }

    public void setNextDayPrice(Double nextDayPrice) {
        this.nextDayPrice = nextDayPrice;
    }

    public Integer getActiveSameDayTime() {
        return activeSameDayTime;
    }

    public void setActiveSameDayTime(Integer activeSameDayTime) {
        this.activeSameDayTime = activeSameDayTime;
    }

    public Integer getActiveNextDayTime() {
        return activeNextDayTime;
    }

    public void setActiveNextDayTime(Integer activeNextDayTime) {
        this.activeNextDayTime = activeNextDayTime;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getIsused() {
        return isused;
    }

    public void setIsused(Boolean isused) {
        this.isused = isused;
    }
}
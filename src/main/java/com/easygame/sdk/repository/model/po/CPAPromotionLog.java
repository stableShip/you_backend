package com.easygame.sdk.repository.model.po;

import java.util.Date;

public class CPAPromotionLog {
    private Integer id;

    private Integer promotionId;

    private String promotionCode;

    private String appKey;

    private Integer channelId;

    private Integer operaterId;

    private Integer appId;

    private String appNickname;

    private String beforeAppNickname;

    private Integer lastestType;

    private Double lastestSameDayPrice;

    private Double lastestNextDayPrice;

    private Double lastestCpsPercent;

    private Double lastestCptPrice;

    private Integer beforeType;

    private Double beforeSameDayPrice;

    private Double beforeNextDayPrice;

    private Double beforeCpsPercent;

    private Double beforeCptPrice;

    private Byte lastestActiveSameTime;

    private Byte lastestActiveNextTime;

    private Byte beforeActiveSameTime;

    private Byte beforeActiveNextTime;

    private Byte operaterType;

    private Date creationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode == null ? null : promotionCode.trim();
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(Integer operaterId) {
        this.operaterId = operaterId;
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

    public String getBeforeAppNickname() {
        return beforeAppNickname;
    }

    public void setBeforeAppNickname(String beforeAppNickname) {
        this.beforeAppNickname = beforeAppNickname == null ? null : beforeAppNickname.trim();
    }

    public Integer getLastestType() {
        return lastestType;
    }

    public void setLastestType(Integer lastestType) {
        this.lastestType = lastestType;
    }

    public Double getLastestSameDayPrice() {
        return lastestSameDayPrice;
    }

    public void setLastestSameDayPrice(Double lastestSameDayPrice) {
        this.lastestSameDayPrice = lastestSameDayPrice;
    }

    public Double getLastestNextDayPrice() {
        return lastestNextDayPrice;
    }

    public void setLastestNextDayPrice(Double lastestNextDayPrice) {
        this.lastestNextDayPrice = lastestNextDayPrice;
    }

    public Double getLastestCpsPercent() {
        return lastestCpsPercent;
    }

    public void setLastestCpsPercent(Double lastestCpsPercent) {
        this.lastestCpsPercent = lastestCpsPercent;
    }

    public Double getLastestCptPrice() {
        return lastestCptPrice;
    }

    public void setLastestCptPrice(Double lastestCptPrice) {
        this.lastestCptPrice = lastestCptPrice;
    }

    public Integer getBeforeType() {
        return beforeType;
    }

    public void setBeforeType(Integer beforeType) {
        this.beforeType = beforeType;
    }

    public Double getBeforeSameDayPrice() {
        return beforeSameDayPrice;
    }

    public void setBeforeSameDayPrice(Double beforeSameDayPrice) {
        this.beforeSameDayPrice = beforeSameDayPrice;
    }

    public Double getBeforeNextDayPrice() {
        return beforeNextDayPrice;
    }

    public void setBeforeNextDayPrice(Double beforeNextDayPrice) {
        this.beforeNextDayPrice = beforeNextDayPrice;
    }

    public Double getBeforeCpsPercent() {
        return beforeCpsPercent;
    }

    public void setBeforeCpsPercent(Double beforeCpsPercent) {
        this.beforeCpsPercent = beforeCpsPercent;
    }

    public Double getBeforeCptPrice() {
        return beforeCptPrice;
    }

    public void setBeforeCptPrice(Double beforeCptPrice) {
        this.beforeCptPrice = beforeCptPrice;
    }

    public Byte getLastestActiveSameTime() {
        return lastestActiveSameTime;
    }

    public void setLastestActiveSameTime(Byte lastestActiveSameTime) {
        this.lastestActiveSameTime = lastestActiveSameTime;
    }

    public Byte getLastestActiveNextTime() {
        return lastestActiveNextTime;
    }

    public void setLastestActiveNextTime(Byte lastestActiveNextTime) {
        this.lastestActiveNextTime = lastestActiveNextTime;
    }

    public Byte getBeforeActiveSameTime() {
        return beforeActiveSameTime;
    }

    public void setBeforeActiveSameTime(Byte beforeActiveSameTime) {
        this.beforeActiveSameTime = beforeActiveSameTime;
    }

    public Byte getBeforeActiveNextTime() {
        return beforeActiveNextTime;
    }

    public void setBeforeActiveNextTime(Byte beforeActiveNextTime) {
        this.beforeActiveNextTime = beforeActiveNextTime;
    }

    public Byte getOperaterType() {
        return operaterType;
    }

    public void setOperaterType(Byte operaterType) {
        this.operaterType = operaterType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
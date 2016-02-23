package com.easygame.sdk.repository.model.po;

public class NotificationAd {
    private Integer id;

    private String name;

    private String appName;

    private String promotionWord;

    private String iconUrl;

    private String downloadUrl;

    private String cpaAppkey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getPromotionWord() {
        return promotionWord;
    }

    public void setPromotionWord(String promotionWord) {
        this.promotionWord = promotionWord == null ? null : promotionWord.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
    }

    public String getCpaAppkey() {
        return cpaAppkey;
    }

    public void setCpaAppkey(String cpaAppkey) {
        this.cpaAppkey = cpaAppkey == null ? null : cpaAppkey.trim();
    }
}
package com.easygame.sdk.repository.model.po;

public class ScreenAd {
    private Integer id;

    private String name;

    private String imageUrl;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
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
package com.easygame.sdk.repository.model.vo.backend.ad;

public class NotificationAdShowVO {
	
	private Integer id;
	
	private String name;
	
	private String appName;
	
	private String iconUrl;
	
	private String promotionWord;
	
	private String downloadUrl;
	
	private String cpaAppKey;

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
		this.name = name;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getPromotionWord() {
		return promotionWord;
	}

	public void setPromotionWord(String promotionWord) {
		this.promotionWord = promotionWord;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getCpaAppKey() {
		return cpaAppKey;
	}

	public void setCpaAppKey(String cpaAppKey) {
		this.cpaAppKey = cpaAppKey;
	}
	
}
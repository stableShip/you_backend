package com.easygame.sdk.repository.model.dto.backend.market;

public class AppNotificationModifyDTO {
	
	private String appName;
	
	private Integer appId;
	
	private Integer appNotificationId;
	
	private String iconUrl;
	
	private String packageName;
	
	private String promotionWord;

	private String downloadUrl;
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Integer getAppNotificationId() {
		return appNotificationId;
	}

	public void setAppNotificationId(Integer appNotificationId) {
		this.appNotificationId = appNotificationId;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
	
}
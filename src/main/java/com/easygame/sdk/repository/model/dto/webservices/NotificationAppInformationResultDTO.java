package com.easygame.sdk.repository.model.dto.webservices;

import java.io.Serializable;

public class NotificationAppInformationResultDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String appName;

	private String appIcon;

	private String appPromotionWord;

	private String appPackageName;

	private String appDownloadUrl;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppIcon() {
		return appIcon;
	}

	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}

	public String getAppPromotionWord() {
		return appPromotionWord;
	}

	public void setAppPromotionWord(String appPromotionWord) {
		this.appPromotionWord = appPromotionWord;
	}

	public String getAppPackageName() {
		return appPackageName;
	}

	public void setAppPackageName(String appPackageName) {
		this.appPackageName = appPackageName;
	}

	public String getAppDownloadUrl() {
		return appDownloadUrl;
	}

	public void setAppDownloadUrl(String appDownloadUrl) {
		this.appDownloadUrl = appDownloadUrl;
	}

}
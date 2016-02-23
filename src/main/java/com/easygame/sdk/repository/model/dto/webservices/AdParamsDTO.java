package com.easygame.sdk.repository.model.dto.webservices;

public class AdParamsDTO {
	
	/** 手机标识 */
	private String imei;
	
	/** 应用标识 */
	private String appKey;
	
	/** 广告ID */
	private Integer adId;

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	
}
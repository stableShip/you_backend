package com.easygame.sdk.repository.model.vo.backend.ad;

public class BannerAdShowVO {
	
	private Integer id;
	
	private String name;
	
	private String imageUrl;
	
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

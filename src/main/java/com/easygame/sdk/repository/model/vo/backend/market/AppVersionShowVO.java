package com.easygame.sdk.repository.model.vo.backend.market;

public class AppVersionShowVO {
	
	private Integer id;
	
	private String versionCode;
	
	private String versionName;
	
	private Integer size;
	
	private Integer urlCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getUrlCount() {
		return urlCount;
	}

	public void setUrlCount(Integer urlCount) {
		this.urlCount = urlCount;
	}
	
}

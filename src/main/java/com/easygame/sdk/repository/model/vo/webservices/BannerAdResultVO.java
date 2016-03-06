package com.easygame.sdk.repository.model.vo.webservices;

import java.util.List;

import com.easygame.sdk.repository.model.po.BannerAd;

public class BannerAdResultVO {

	private Integer changeAdTime;
	
	private Integer keepAdTime;
	
	private List<BannerAd> bannerAds;

	public Integer getChangeAdTime() {
		return changeAdTime;
	}

	public void setChangeAdTime(Integer changeAdTime) {
		this.changeAdTime = changeAdTime;
	}

	public Integer getKeepAdTime() {
		return keepAdTime;
	}

	public void setKeepAdTime(Integer keepAdTime) {
		this.keepAdTime = keepAdTime;
	}

	public List<BannerAd> getBannerAds() {
		return bannerAds;
	}

	public void setBannerAds(List<BannerAd> bannerAds) {
		this.bannerAds = bannerAds;
	}
	
}

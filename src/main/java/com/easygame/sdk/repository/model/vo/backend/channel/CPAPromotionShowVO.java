package com.easygame.sdk.repository.model.vo.backend.channel;

import java.io.Serializable;

public class CPAPromotionShowVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String promotionCode;

	private String appKey;

	private String channelName;

	private String subChannelName;

	private String subChannelCode;
	
	private String channelCode;

	private String appName;

	private String appNickName;

	private Integer type;

	private Double sameDayPrice;
	
	private Double nextDayPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getSubChannelName() {
		return subChannelName;
	}

	public void setSubChannelName(String subChannelName) {
		this.subChannelName = subChannelName;
	}

	public String getSubChannelCode() {
		return subChannelCode;
	}

	public void setSubChannelCode(String subChannelCode) {
		this.subChannelCode = subChannelCode;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getAppNickName() {
		return appNickName;
	}

	public void setAppNickName(String appNickName) {
		this.appNickName = appNickName;
	}

	public Double getSameDayPrice() {
		return sameDayPrice;
	}

	public void setSameDayPrice(Double sameDayPrice) {
		this.sameDayPrice = sameDayPrice;
	}

	public Double getNextDayPrice() {
		return nextDayPrice;
	}

	public void setNextDayPrice(Double nextDayPrice) {
		this.nextDayPrice = nextDayPrice;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

}
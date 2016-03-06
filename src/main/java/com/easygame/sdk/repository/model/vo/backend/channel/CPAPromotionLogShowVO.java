package com.easygame.sdk.repository.model.vo.backend.channel;

import java.io.Serializable;

public class CPAPromotionLogShowVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String date;
	
	private String channelName;
	
	private String subChannelName;
	
	private String appName;
	
	private String appNickName;
	
	private String beforeAppNickName;
	
	private Integer type;
	
	private Integer beforeType;
	
	private Double sameDayPrice;
	
	private Double beforeSameDayPrice;
	
	private Double nextDayPrice;
	
	private Double beforeNextDayPrice;
	
	private int activeSameTime;
	
	private int beforeActiveSameTime;
	
	private int activeNextTime;
	
	private int beforeActiveNextTime;
	
	private String operaterName;
	
	private Integer operaterType;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppNickName() {
		return appNickName;
	}

	public void setAppNickName(String appNickName) {
		this.appNickName = appNickName;
	}

	public String getBeforeAppNickName() {
		return beforeAppNickName;
	}

	public void setBeforeAppNickName(String beforeAppNickName) {
		this.beforeAppNickName = beforeAppNickName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getBeforeType() {
		return beforeType;
	}

	public void setBeforeType(Integer beforeType) {
		this.beforeType = beforeType;
	}

	public Double getSameDayPrice() {
		return sameDayPrice;
	}

	public void setSameDayPrice(Double sameDayPrice) {
		this.sameDayPrice = sameDayPrice;
	}

	public Double getBeforeSameDayPrice() {
		return beforeSameDayPrice;
	}

	public void setBeforeSameDayPrice(Double beforeSameDayPrice) {
		this.beforeSameDayPrice = beforeSameDayPrice;
	}

	public Double getNextDayPrice() {
		return nextDayPrice;
	}

	public void setNextDayPrice(Double nextDayPrice) {
		this.nextDayPrice = nextDayPrice;
	}

	public Double getBeforeNextDayPrice() {
		return beforeNextDayPrice;
	}

	public void setBeforeNextDayPrice(Double beforeNextDayPrice) {
		this.beforeNextDayPrice = beforeNextDayPrice;
	}

	public int getActiveSameTime() {
		return activeSameTime;
	}

	public void setActiveSameTime(int activeSameTime) {
		this.activeSameTime = activeSameTime;
	}

	public int getBeforeActiveSameTime() {
		return beforeActiveSameTime;
	}

	public void setBeforeActiveSameTime(int beforeActiveSameTime) {
		this.beforeActiveSameTime = beforeActiveSameTime;
	}

	public int getActiveNextTime() {
		return activeNextTime;
	}

	public void setActiveNextTime(int activeNextTime) {
		this.activeNextTime = activeNextTime;
	}

	public int getBeforeActiveNextTime() {
		return beforeActiveNextTime;
	}

	public void setBeforeActiveNextTime(int beforeActiveNextTime) {
		this.beforeActiveNextTime = beforeActiveNextTime;
	}

	public String getOperaterName() {
		return operaterName;
	}

	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}

	public Integer getOperaterType() {
		return operaterType;
	}

	public void setOperaterType(Integer operaterType) {
		this.operaterType = operaterType;
	}
	
}

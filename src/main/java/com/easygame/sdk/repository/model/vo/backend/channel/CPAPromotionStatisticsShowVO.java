package com.easygame.sdk.repository.model.vo.backend.channel;

import java.io.Serializable;

public class CPAPromotionStatisticsShowVO implements Serializable {

	public static final String BEGINTIME = "beginTime";
	public static final String ENDTIME = "endTime";
	public static final String APPNAME = "appName";
	public static final String APPNICKNAME = "appNickName";
	public static final String TYPE = "type";

	private static final long serialVersionUID = 1L;

	private Integer id;

	/** 渠道名称 */
	private String channelName;

	/** 子渠道名称 */
	private String subChannelName;

	/** 应用名称 */
	private String appName;

	private String appNickName;

	private int sameDayTime;
	
	private Double sameDayPrice;
	
	private int nextDayTime;
	
	private Double nextDayPrice;
	
	private int sameZero;
	
	private int sameFive;
	
	private int sameTen;
	
	private int sameFifteen;
	
	private int sameTwenty;
	
	private int sameTwentyFive;
	
	private int sameThirty;
	
	private int nextZero;
	
	private int nextFive;
	
	private int nextTen;
	
	private int nextFifteen;
	
	private int nextTwenty;
	
	private int nextTwentyFive;
	
	private int nextThirty;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getSameDayTime() {
		return sameDayTime;
	}

	public void setSameDayTime(int sameDayTime) {
		this.sameDayTime = sameDayTime;
	}

	public Double getSameDayPrice() {
		return sameDayPrice;
	}

	public void setSameDayPrice(Double sameDayPrice) {
		this.sameDayPrice = sameDayPrice;
	}

	public int getNextDayTime() {
		return nextDayTime;
	}

	public void setNextDayTime(int nextDayTime) {
		this.nextDayTime = nextDayTime;
	}

	public Double getNextDayPrice() {
		return nextDayPrice;
	}

	public void setNextDayPrice(Double nextDayPrice) {
		this.nextDayPrice = nextDayPrice;
	}

	public int getSameFive() {
		return sameFive;
	}

	public void setSameFive(int sameFive) {
		this.sameFive = sameFive;
	}

	public int getSameTen() {
		return sameTen;
	}

	public void setSameTen(int sameTen) {
		this.sameTen = sameTen;
	}

	public int getSameFifteen() {
		return sameFifteen;
	}

	public void setSameFifteen(int sameFifteen) {
		this.sameFifteen = sameFifteen;
	}

	public int getSameTwenty() {
		return sameTwenty;
	}

	public void setSameTwenty(int sameTwenty) {
		this.sameTwenty = sameTwenty;
	}

	public int getSameTwentyFive() {
		return sameTwentyFive;
	}

	public void setSameTwentyFive(int sameTwentyFive) {
		this.sameTwentyFive = sameTwentyFive;
	}

	public int getSameThirty() {
		return sameThirty;
	}

	public void setSameThirty(int sameThirty) {
		this.sameThirty = sameThirty;
	}

	public int getNextFive() {
		return nextFive;
	}

	public void setNextFive(int nextFive) {
		this.nextFive = nextFive;
	}

	public int getNextTen() {
		return nextTen;
	}

	public void setNextTen(int nextTen) {
		this.nextTen = nextTen;
	}

	public int getNextFifteen() {
		return nextFifteen;
	}

	public void setNextFifteen(int nextFifteen) {
		this.nextFifteen = nextFifteen;
	}

	public int getNextTwenty() {
		return nextTwenty;
	}

	public void setNextTwenty(int nextTwenty) {
		this.nextTwenty = nextTwenty;
	}

	public int getNextTwentyFive() {
		return nextTwentyFive;
	}

	public void setNextTwentyFive(int nextTwentyFive) {
		this.nextTwentyFive = nextTwentyFive;
	}

	public int getNextThirty() {
		return nextThirty;
	}

	public void setNextThirty(int nextThirty) {
		this.nextThirty = nextThirty;
	}

	public int getSameZero() {
		return sameZero;
	}

	public void setSameZero(int sameZero) {
		this.sameZero = sameZero;
	}

	public int getNextZero() {
		return nextZero;
	}

	public void setNextZero(int nextZero) {
		this.nextZero = nextZero;
	}

}
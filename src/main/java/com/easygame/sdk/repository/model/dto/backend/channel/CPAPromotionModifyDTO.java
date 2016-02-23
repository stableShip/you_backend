package com.easygame.sdk.repository.model.dto.backend.channel;

import java.io.Serializable;

import com.easygame.sdk.repository.model.po.CPAPromotion;

public class CPAPromotionModifyDTO extends CPAPromotion implements Serializable {

	private static final long serialVersionUID = 1L;

	private String channelName;

	private String appName;

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

}

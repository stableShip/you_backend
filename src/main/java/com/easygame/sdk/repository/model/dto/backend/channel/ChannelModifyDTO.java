package com.easygame.sdk.repository.model.dto.backend.channel;

import java.io.Serializable;

import com.easygame.sdk.repository.model.po.Channel;

public class ChannelModifyDTO extends Channel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String linkmanName;

	private String companyName;

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
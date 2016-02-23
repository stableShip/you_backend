package com.easygame.sdk.repository.model.dto.backend.channel;

import com.easygame.sdk.common.util.Page;

public class ChannelSearchCriteriaDTO {
	
	private String searchChannelCode;
	
	private String searchChannelName;
	
	private String searchSubChannelCode;
	
	private String searchSubChannelName;

	/** 分页信息 */
	private Page pagination;

	public String getSearchChannelCode() {
		return searchChannelCode;
	}

	public void setSearchChannelCode(String searchChannelCode) {
		this.searchChannelCode = (searchChannelCode == null || "".endsWith(searchChannelCode.trim())) ? null
				: searchChannelCode;
	}

	public String getSearchChannelName() {
		return searchChannelName;
	}

	public void setSearchChannelName(String searchChannelName) {
		this.searchChannelName = (searchChannelName == null || "".endsWith(searchChannelName.trim())) ? null
				: searchChannelName;
	}

	public String getSearchSubChannelCode() {
		return searchSubChannelCode;
	}

	public void setSearchSubChannelCode(String searchSubChannelCode) {
		this.searchSubChannelCode = (searchSubChannelCode == null || "".endsWith(searchSubChannelCode.trim())) ? null
				: searchSubChannelCode;
	}

	public String getSearchSubChannelName() {
		return searchSubChannelName;
	}

	public void setSearchSubChannelName(String searchSubChannelName) {
		this.searchSubChannelName = (searchSubChannelName == null || "".endsWith(searchSubChannelName.trim())) ? null
				: searchSubChannelName;
	}

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}

}

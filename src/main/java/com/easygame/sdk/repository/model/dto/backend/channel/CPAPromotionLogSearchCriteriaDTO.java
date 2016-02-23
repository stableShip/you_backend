package com.easygame.sdk.repository.model.dto.backend.channel;

import com.easygame.sdk.common.util.Page;

public class CPAPromotionLogSearchCriteriaDTO {

	private String searchStartTime;

	private String searchEndTime;

	private String searchAppName;

	private String searchAppNickName;

	/**
	 * 分页信息
	 */
	private Page pagination;

	public String getSearchStartTime() {
		return searchStartTime;
	}

	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = (searchStartTime == null || ""
				.endsWith(searchStartTime.trim())) ? null : searchStartTime;
	}

	public String getSearchEndTime() {
		return searchEndTime;
	}

	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = (searchEndTime == null || ""
				.endsWith(searchEndTime.trim())) ? null : searchEndTime;
	}

	public String getSearchAppName() {
		return searchAppName;
	}

	public void setSearchAppName(String searchAppName) {
		this.searchAppName = (searchAppName == null || ""
				.endsWith(searchAppName.trim())) ? null : searchAppName;
	}

	public String getSearchAppNickName() {
		return searchAppNickName;
	}

	public void setSearchAppNickName(String searchAppNickName) {
		this.searchAppNickName = (searchAppNickName == null || ""
				.endsWith(searchAppNickName.trim())) ? null : searchAppNickName;
	}

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}

}

package com.easygame.sdk.repository.model.dto.backend.channel;

import com.easygame.sdk.common.util.Page;

public class CPAPromotionStatisticsSearchCriteriaDTO {

	private Integer searchDataType = 0; // 0为按日显示，1为按月显示

	private String searchStartDay;

	private String searchEndDay;

	private String searchStartMonth;

	private String searchEndMonth;
	
	private String searchChannelName;

	private String searchAppName;

	private String searchAppNickName;

	private Integer searchOrderByColumn = 0;

	private boolean isInternal = false;

	private Integer userId = 0;

	/** 分页信息 */
	private Page pagination;

	public String getCacheKey() {
		return searchDataType + "/" + searchStartDay + "/" + searchEndDay + "/"
				+ searchStartMonth + "/" + searchEndMonth + "/" + searchAppName
				+ "/" + searchAppNickName +  "/" + isInternal
				+ "/" + userId;
	}

	public Integer getSearchDataType() {
		return searchDataType;
	}

	public void setSearchDataType(Integer searchDataType) {
		this.searchDataType = searchDataType;
	}

	public String getSearchStartDay() {
		return searchStartDay;
	}

	public void setSearchStartDay(String searchStartDay) {
		this.searchStartDay = (searchStartDay == null || ""
				.endsWith(searchStartDay.trim())) ? null : searchStartDay;
	}

	public String getSearchEndDay() {
		return searchEndDay;
	}

	public void setSearchEndDay(String searchEndDay) {
		this.searchEndDay = (searchEndDay == null || "".endsWith(searchEndDay
				.trim())) ? null : searchEndDay;
	}

	public String getSearchStartMonth() {
		return searchStartMonth;
	}

	public void setSearchStartMonth(String searchStartMonth) {
		this.searchStartMonth = (searchStartMonth == null || ""
				.endsWith(searchStartMonth.trim())) ? null : searchStartMonth;
	}

	public String getSearchEndMonth() {
		return searchEndMonth;
	}

	public void setSearchEndMonth(String searchEndMonth) {
		this.searchEndMonth = (searchEndMonth == null || ""
				.endsWith(searchEndMonth.trim())) ? null : searchEndMonth;
	}

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
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

	public boolean isInternal() {
		return isInternal;
	}

	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSearchChannelName() {
		return searchChannelName;
	}

	public void setSearchChannelName(String searchChannelName) {
		this.searchChannelName = (searchChannelName == null || ""
				.endsWith(searchChannelName.trim())) ? null : searchChannelName;
	}

	public Integer getSearchOrderByColumn() {
		return searchOrderByColumn;
	}

	public void setSearchOrderByColumn(Integer searchOrderByColumn) {
		this.searchOrderByColumn = searchOrderByColumn;
	}
	
}

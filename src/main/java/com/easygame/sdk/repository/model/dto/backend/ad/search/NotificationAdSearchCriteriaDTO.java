package com.easygame.sdk.repository.model.dto.backend.ad.search;

import com.easygame.sdk.common.util.Page;

public class NotificationAdSearchCriteriaDTO {
	
	private String searchNotificationAdName;
	
	private String searchNotificationAdAppName;
	
	private String searchCpaAppKey;
	
	private Page pagination;

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}

	public String getSearchNotificationAdName() {
		return searchNotificationAdName;
	}

	public void setSearchNotificationAdName(String searchNotificationAdName) {
		this.searchNotificationAdName = searchNotificationAdName;
	}

	public String getSearchNotificationAdAppName() {
		return searchNotificationAdAppName;
	}

	public void setSearchNotificationAdAppName(String searchNotificationAdAppName) {
		this.searchNotificationAdAppName = searchNotificationAdAppName;
	}

	public String getSearchCpaAppKey() {
		return searchCpaAppKey;
	}

	public void setSearchCpaAppKey(String searchCpaAppKey) {
		this.searchCpaAppKey = searchCpaAppKey;
	}

}
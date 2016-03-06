package com.easygame.sdk.repository.model.dto.backend.ad.search;

import com.easygame.sdk.common.util.Page;

public class ScreenAdSearchCriteriaDTO {

	private String searchScreenAdName;

	private String searchCpaAppKey;

	private Page pagination;

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}

	public String getSearchScreenAdName() {
		return searchScreenAdName;
	}

	public void setSearchScreenAdName(String searchScreenAdName) {
		this.searchScreenAdName = searchScreenAdName;
	}

	public String getSearchCpaAppKey() {
		return searchCpaAppKey;
	}

	public void setSearchCpaAppKey(String searchCpaAppKey) {
		this.searchCpaAppKey = searchCpaAppKey;
	}

}

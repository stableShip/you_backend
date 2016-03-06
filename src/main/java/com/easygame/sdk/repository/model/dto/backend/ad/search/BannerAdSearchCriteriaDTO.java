package com.easygame.sdk.repository.model.dto.backend.ad.search;

import com.easygame.sdk.common.util.Page;

public class BannerAdSearchCriteriaDTO {

	private String searchBannerAdName;

	private String searchCpaAppKey;

	private Page pagination;

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}

	public String getSearchBannerAdName() {
		return searchBannerAdName;
	}

	public void setSearchBannerAdName(String searchBannerAdName) {
		this.searchBannerAdName = searchBannerAdName;
	}

	public String getSearchCpaAppKey() {
		return searchCpaAppKey;
	}

	public void setSearchCpaAppKey(String searchCpaAppKey) {
		this.searchCpaAppKey = searchCpaAppKey;
	}

}

package com.easygame.sdk.repository.model.dto.backend.ad.search;

import com.easygame.sdk.common.util.Page;

public class GamecenterAdSearchCriteriaDTO {

	private String searchGamecenterAdName;

	private Page pagination;

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}

	public String getSearchGamecenterAdName() {
		return searchGamecenterAdName;
	}

	public void setSearchGamecenterAdName(String searchGamecenterAdName) {
		this.searchGamecenterAdName = searchGamecenterAdName;
	}

	
}

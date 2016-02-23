package com.easygame.sdk.repository.model.dto.backend.market;

import com.easygame.sdk.common.util.Page;

public class AppSearchCriteriaDTO {
	
	private String searchName;
	
	private Integer searchTypeId = 0;
	
	/**
	 * 分页信息
	 */
	private Page pagination;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = (searchName == null || "".endsWith(searchName.trim())) ? null
				: searchName;
	}

	public Integer getSearchTypeId() {
		return searchTypeId;
	}

	public void setSearchTypeId(Integer searchTypeId) {
		this.searchTypeId = searchTypeId;
	}

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}

}

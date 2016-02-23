package com.easygame.sdk.repository.model.dto.backend.general;

import com.easygame.sdk.common.util.Page;

/** 公司查询条件 */
public class CompanySearchCriteriaDTO {

	/** 公司名称 */
	private String searchName;

	/** 分页信息 */
	private Page pagination;

	public String getCacheKey() {
		return searchName + "/" + pagination.toString();
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = (searchName == null || "".endsWith(searchName.trim())) ? null
				: searchName;
	}

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}

}
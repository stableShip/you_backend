package com.easygame.sdk.repository.model.dto.backend.general;

import com.easygame.sdk.common.util.Page;

/**
 * 用户查询条件
 */
public class AccountSearchCriteriaDTO {

	/**
	 * 用户账号
	 */
	private String searchAccount;
	
	/**
	 * 用户姓名
	 */
	private String searchName;
	
	/**
	 * 所属公司
	 */
	private String searchCompanyName;
	
	/**
	 * 分页信息
	 */
	private Page pagination;

	public String getSearchAccount() {
		return searchAccount;
	}

	public void setSearchAccount(String searchAccount) {
		this.searchAccount = (searchAccount == null || "".endsWith(searchAccount.trim())) ? null
				: searchAccount;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = (searchName == null || "".endsWith(searchName.trim())) ? null
				: searchName;
	}
	
	public String getSearchCompanyName() {
		return searchCompanyName;
	}

	public void setSearchCompanyName(String searchCompanyName) {
		this.searchCompanyName = (searchCompanyName == null || "".endsWith(searchCompanyName.trim())) ? null
				: searchCompanyName;
	}

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}
	
}

package com.easygame.sdk.repository.model.dto.backend.channel;

import com.easygame.sdk.common.util.Page;

public class CPAPromotionSearchCriteriaDTO {

	private String searchPromotionKEY;
	
	private String searchChannelName;

	private String searchAppName;

	/** 分页信息 */
	private Page pagination;

	public String getSearchAppName() {
		return searchAppName;
	}

	public void setSearchAppName(String searchAppName) {
		this.searchAppName = (searchAppName == null || ""
				.endsWith(searchAppName.trim())) ? null : searchAppName;
	}
	
	public String getSearchPromotionKEY() {
		return searchPromotionKEY;
	}

	public void setSearchPromotionKEY(String searchPromotionKEY) {
		this.searchPromotionKEY = (searchPromotionKEY == null || ""
				.endsWith(searchPromotionKEY.trim())) ? null : searchPromotionKEY;
	}

	public String getSearchChannelName() {
		return searchChannelName;
	}

	public void setSearchChannelName(String searchChannelName) {
		this.searchChannelName = (searchChannelName == null || ""
				.endsWith(searchChannelName.trim())) ? null : searchChannelName;
	}

	public Page getPagination() {
		return pagination;
	}

	public void setPagination(Page pagination) {
		this.pagination = pagination;
	}

}

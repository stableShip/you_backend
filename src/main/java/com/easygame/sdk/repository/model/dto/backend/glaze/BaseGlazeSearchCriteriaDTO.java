package com.easygame.sdk.repository.model.dto.backend.glaze;

import com.easygame.sdk.common.util.Page;

public class BaseGlazeSearchCriteriaDTO {

    private String searchName;
    /**
     * 分页信息
     */
    private Page pagination;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = (searchName == null || "".endsWith(searchName.trim())) ? null : searchName;
    }

    public Page getPagination() {
        return pagination;
    }

    public void setPagination(Page pagination) {
        this.pagination = pagination;
    }

}

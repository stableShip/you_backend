package com.easygame.sdk.repository.model.dto.backend.glaze;

import com.easygame.sdk.common.util.Page;

public class SampleGlazeSearchCriteriaDTO {

    private Integer id;



    private String searchName;

    private String customerName;

    /**
     * 分页信息
     */
    private Page pagination;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName =(searchName == null || "".endsWith(searchName.trim())) ? null : searchName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Page getPagination() {
        return pagination;
    }

    public void setPagination(Page pagination) {
        this.pagination = pagination;
    }

}

package com.easygame.sdk.repository.model.dto.backend.glaze;

import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.repository.model.po.ProductOrder;

public class ProductOrderSearchCriteriaDTO extends ProductOrder{

    private String SampleGlazeName;

    private String companyName;

    private String searchStartDay;

    private String searchEndDay;


    public String getSampleGlazeName() {
        return SampleGlazeName;
    }

    public void setSampleGlazeName(String sampleGlazeName) {
        SampleGlazeName = sampleGlazeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 分页信息
     */
    private Page pagination;

    public Page getPagination() {
        return pagination;
    }

    public void setPagination(Page pagination) {
        this.pagination = pagination;
    }

    public String getSearchStartDay() {
        return searchStartDay;
    }

    public void setSearchStartDay(String searchStartDay) {
        this.searchStartDay = searchStartDay;
    }

    public String getSearchEndDay() {
        return searchEndDay;
    }

    public void setSearchEndDay(String searchEndDay) {
        this.searchEndDay = searchEndDay;
    }

}

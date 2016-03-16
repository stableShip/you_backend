package com.easygame.sdk.repository.model.vo.backend.glaze;

import com.easygame.sdk.repository.model.po.ProductOrder;

import java.io.Serializable;

public class ProductOrderShowVO implements Serializable {

    private static final long serialVersionUID = 7255426281146869404L;
    private Integer id;

    private Integer content;

    private String sample_glaze_name;

    private String creation_date;

    private String company_name;

    private String product_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public String getSample_glaze_name() {
        return sample_glaze_name;
    }

    public void setSample_glaze_name(String sample_glaze_name) {
        this.sample_glaze_name = sample_glaze_name;
    }


    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getProduct_date() {
        return product_date;
    }

    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }
}
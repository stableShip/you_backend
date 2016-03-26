package com.easygame.sdk.repository.model.vo.backend.glaze;

import java.io.Serializable;

public class SampleGlazeShowVO implements Serializable {

    private static final long serialVersionUID = 7255426281146869404L;

    private Integer id;

    private String name;


    private String customer_name;

    private String sample_glaze_name;

    private double fineness;

    private String creation_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getSample_glaze_name() {
        return sample_glaze_name;
    }

    public void setSample_glaze_name(String sample_glaze_name) {
        this.sample_glaze_name = sample_glaze_name;
    }

    public double getFineness() {
        return fineness;
    }

    public void setFineness(double fineness) {
        this.fineness = fineness;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
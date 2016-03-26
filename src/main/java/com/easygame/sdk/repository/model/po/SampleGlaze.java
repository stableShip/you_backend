package com.easygame.sdk.repository.model.po;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SampleGlaze {
    private Integer id;
    @NotBlank(message = "名称不能为空")
    private String name;

    private double fineness;

    private Date creation_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFineness() {
        return fineness;
    }

    public void setFineness(double fineness) {
        this.fineness = fineness;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
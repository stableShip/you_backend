package com.easygame.sdk.repository.model.vo.backend.glaze;

import java.io.Serializable;

public class BaseGlazeShowVO implements Serializable {

    private static final long serialVersionUID = 7255426281146869404L;
    private Integer id;

    private String name;

    private double water_content;

    private String comment;

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

    public double getWater_content() {
        return water_content;
    }


    public String getComment() {
        return comment;
    }

    public void setWater_content(double water_content) {
        this.water_content = water_content;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
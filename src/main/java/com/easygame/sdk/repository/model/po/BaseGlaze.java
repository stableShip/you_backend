package com.easygame.sdk.repository.model.po;

import java.util.Date;

public class BaseGlaze {
    private Integer id;

    private String name;

    private Integer water_content;

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

    public Integer getWater_content() {
        return water_content;
    }

    public void setWater_content(Integer water_content) {
        this.water_content = water_content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
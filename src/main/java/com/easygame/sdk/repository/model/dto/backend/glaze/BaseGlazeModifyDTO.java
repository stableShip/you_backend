package com.easygame.sdk.repository.model.dto.backend.glaze;

import java.io.Serializable;

import com.easygame.sdk.repository.model.po.BaseGlaze;

public class BaseGlazeModifyDTO extends BaseGlaze implements Serializable {

    private static final long serialVersionUID = -4124330501835134622L;

    private String name;

    private Integer water_content;

    private String comment;

    @Override
    public Integer getWater_content() {
        return water_content;
    }

    @Override
    public void setWater_content(Integer water_content) {
        this.water_content = water_content;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }
}
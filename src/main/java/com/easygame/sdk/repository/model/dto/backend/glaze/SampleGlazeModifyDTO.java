package com.easygame.sdk.repository.model.dto.backend.glaze;

import com.easygame.sdk.repository.model.po.SampleGlaze;

import java.io.Serializable;

public class SampleGlazeModifyDTO extends SampleGlaze implements Serializable {

    private static final long serialVersionUID = -4124330501835134622L;

    private String name;

    private Integer fineness;

    private String customer;



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
package com.easygame.sdk.repository.model.dto.backend.toner;

import com.easygame.sdk.repository.model.po.Toner;

import java.io.Serializable;

public class TonerModifyDTO extends Toner implements Serializable {

    private static final long serialVersionUID = -4124330501835134622L;

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


}
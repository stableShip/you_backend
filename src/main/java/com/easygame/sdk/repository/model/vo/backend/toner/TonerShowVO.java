package com.easygame.sdk.repository.model.vo.backend.toner;

import java.io.Serializable;

public class TonerShowVO implements Serializable {

    private static final long serialVersionUID = 7255426281146869404L;
    private Integer id;

    private String name;

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

}
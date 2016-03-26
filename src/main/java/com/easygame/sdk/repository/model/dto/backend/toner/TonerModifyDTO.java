package com.easygame.sdk.repository.model.dto.backend.toner;

import com.easygame.sdk.repository.model.po.Toner;

import java.io.Serializable;

public class TonerModifyDTO extends Toner implements Serializable {

    private static final long serialVersionUID = -4124330501835134622L;

    private double content;

    private Integer sampleGlazeId;

    public Integer getSampleGlazeId() {
        return sampleGlazeId;
    }

    public void setSampleGlazeId(Integer sampleGlazeId) {
        this.sampleGlazeId = sampleGlazeId;
    }

    public double getContent() {
        return content;
    }

    public void setContent(double content) {
        this.content = content;
    }
}
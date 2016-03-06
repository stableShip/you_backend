package com.easygame.sdk.repository.model.dto.backend.glaze;

import com.easygame.sdk.repository.model.dto.backend.toner.TonerModifyDTO;
import com.easygame.sdk.repository.model.po.SampleGlaze;


import java.io.Serializable;
import java.util.List;

public class SampleGlazeModifyDTO extends SampleGlaze implements Serializable {

    private static final long serialVersionUID = -4124330501835134622L;

    private String customer_id;

    private List<TonerModifyDTO> toners;

    public List<TonerModifyDTO> getToners() {
        return toners;
    }

    public void setToners(List<TonerModifyDTO> toners) {
        this.toners = toners;
    }


    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
}
package com.easygame.sdk.repository.model.dto.backend.glaze;

import com.easygame.sdk.repository.model.dto.backend.general.CompanyModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.toner.TonerModifyDTO;
import com.easygame.sdk.repository.model.po.SampleGlaze;


import java.io.Serializable;
import java.util.List;

public class SampleGlazeModifyDTO extends SampleGlaze implements Serializable {

    private static final long serialVersionUID = -4124330501835134622L;

    private CompanyModifyDTO customer;

    private List<TonerModifyDTO> toners;

    private List<BaseGlazeModifyDTO> baseGlazes;

    public List<BaseGlazeModifyDTO> getBaseGlazes() {
        return baseGlazes;
    }

    public void setBaseGlazes(List<BaseGlazeModifyDTO> baseGlazes) {
        this.baseGlazes = baseGlazes;
    }

    public List<TonerModifyDTO> getToners() {
        return toners;
    }

    public void setToners(List<TonerModifyDTO> toners) {
        this.toners = toners;
    }

    public CompanyModifyDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CompanyModifyDTO customer) {
        this.customer = customer;
    }
}
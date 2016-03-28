package com.easygame.sdk.repository.model.dto.backend.glaze;

import com.easygame.sdk.repository.model.po.ProductOrder;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProductOrderModifyDTO extends ProductOrder implements Serializable {

    private static final long serialVersionUID = -4124330501835134622L;

    @NotNull(message = "请选择样品釉")
    private Integer sampleGlazeId;

    private String companyName;

    private String sampleGlazeName;

    public Integer getSampleGlazeId() {
        return sampleGlazeId;
    }

    public void setSampleGlazeId(Integer sampleGlazeId) {
        this.sampleGlazeId = sampleGlazeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSampleGlazeName() {
        return sampleGlazeName;
    }

    public void setSampleGlazeName(String sampleGlazeName) {
        this.sampleGlazeName = sampleGlazeName;
    }
}
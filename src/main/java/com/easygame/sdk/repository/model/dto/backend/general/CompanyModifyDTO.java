package com.easygame.sdk.repository.model.dto.backend.general;

import java.io.Serializable;

import com.easygame.sdk.repository.model.po.Company;

public class CompanyModifyDTO extends Company implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer sampleGlazeId;

	public Integer getSampleGlazeId() {
		return sampleGlazeId;
	}

	public void setSampleGlazeId(Integer sampleGlazeId) {
		this.sampleGlazeId = sampleGlazeId;
	}
}

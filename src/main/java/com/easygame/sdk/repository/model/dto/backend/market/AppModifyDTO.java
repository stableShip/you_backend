package com.easygame.sdk.repository.model.dto.backend.market;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class AppModifyDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "应用名称不能为空")
	private String name;

	private Integer typeId;

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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}
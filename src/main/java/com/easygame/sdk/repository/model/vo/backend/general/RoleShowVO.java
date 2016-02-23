package com.easygame.sdk.repository.model.vo.backend.general;

public class RoleShowVO {
	
	public Integer id;
	
	public String name;
	
	public boolean isInternal;

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

	public boolean isInternal() {
		return isInternal;
	}

	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}

}
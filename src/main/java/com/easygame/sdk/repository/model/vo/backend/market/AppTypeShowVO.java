package com.easygame.sdk.repository.model.vo.backend.market;

import java.io.Serializable;

public class AppTypeShowVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

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

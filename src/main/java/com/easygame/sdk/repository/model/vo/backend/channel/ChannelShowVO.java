package com.easygame.sdk.repository.model.vo.backend.channel;

import java.io.Serializable;

public class ChannelShowVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String code;

	private String name;

	private String linkman;

	private String linkmanEmail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanEmail() {
		return linkmanEmail;
	}

	public void setLinkmanEmail(String linkmanEmail) {
		this.linkmanEmail = linkmanEmail;
	}

}
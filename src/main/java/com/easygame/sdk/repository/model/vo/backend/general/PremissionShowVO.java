package com.easygame.sdk.repository.model.vo.backend.general;

import java.io.Serializable;

public class PremissionShowVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String pageMark;

	private String pageDesc;

	private Integer roleId;

	private Integer permissionId;

	private int permissionLevel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPageMark() {
		return pageMark;
	}

	public void setPageMark(String pageMark) {
		this.pageMark = pageMark;
	}

	public String getPageDesc() {
		return pageDesc;
	}

	public void setPageDesc(String pageDesc) {
		this.pageDesc = pageDesc;
	}

	public int getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(int permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

}
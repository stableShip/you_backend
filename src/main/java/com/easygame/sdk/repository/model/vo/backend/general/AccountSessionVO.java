package com.easygame.sdk.repository.model.vo.backend.general;

import java.util.List;

/** 放置到session的信息 */
public class AccountSessionVO {
	
	/** id */
	private Integer id;
	
	/** 姓名 */
	private String name;
	
	/** 是否内部人员 */
	private boolean isInternal; 

	/** 权限 */
	private List<PremissionShowVO> permissions;

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

	public List<PremissionShowVO> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PremissionShowVO> permissions) {
		this.permissions = permissions;
	}
	
}

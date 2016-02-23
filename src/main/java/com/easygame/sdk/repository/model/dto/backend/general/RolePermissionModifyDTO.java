package com.easygame.sdk.repository.model.dto.backend.general;

import java.util.List;

import com.easygame.sdk.repository.model.po.Role;
import com.easygame.sdk.repository.model.vo.backend.general.PremissionShowVO;

public class RolePermissionModifyDTO extends Role {
	
	public List<PremissionShowVO> permissions;

	public List<PremissionShowVO> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PremissionShowVO> permissions) {
		this.permissions = permissions;
	}

}

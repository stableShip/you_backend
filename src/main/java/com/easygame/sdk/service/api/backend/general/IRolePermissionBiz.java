package com.easygame.sdk.service.api.backend.general;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.general.RolePermissionModifyDTO;
import com.easygame.sdk.repository.model.po.Permission;
import com.easygame.sdk.repository.model.vo.backend.general.RoleShowVO;

public interface IRolePermissionBiz {
	
	public List<Permission> selectAllPermission();
	
	public List<RoleShowVO> selectAllRole();
	
	public int insertRole(RolePermissionModifyDTO record);
	
	public RolePermissionModifyDTO selectRoleForUpdate(int id);
	
	public int updateRole(RolePermissionModifyDTO record);

}

package com.easygame.sdk.service.impl.backend.general;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.general.RolePermissionMapper;
import com.easygame.sdk.repository.model.dto.backend.general.RolePermissionModifyDTO;
import com.easygame.sdk.repository.model.po.Permission;
import com.easygame.sdk.repository.model.vo.backend.general.RoleShowVO;
import com.easygame.sdk.service.api.backend.general.IRolePermissionBiz;

@Service(value = "rolePermissionBiz")
public class RolePermissionBizImpl implements IRolePermissionBiz {

	@Autowired
	public RolePermissionMapper rolePermissionMapper;

	public List<Permission> selectAllPermission() {
		return rolePermissionMapper.selectAllPermission();
	}

	public List<RoleShowVO> selectAllRole() {
		return rolePermissionMapper.selectAllRole();
	}

	public int insertRole(RolePermissionModifyDTO record) {
		rolePermissionMapper.insertRole(record);

		return rolePermissionMapper.insertRolePermissions(
				record.getPermissions(), record.getId());
	}

	public RolePermissionModifyDTO selectRoleForUpdate(int id) {
		return rolePermissionMapper.selectRoleByPrimaryKey(id);
	}

	public int updateRole(RolePermissionModifyDTO record) {
		rolePermissionMapper.updateRole(record);

		return rolePermissionMapper.updateRolePermissions(
				record.getPermissions(), record.getId());
	}

}
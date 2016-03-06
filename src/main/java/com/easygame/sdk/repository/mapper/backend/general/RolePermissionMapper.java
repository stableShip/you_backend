package com.easygame.sdk.repository.mapper.backend.general;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.general.RolePermissionModifyDTO;
import com.easygame.sdk.repository.model.po.Permission;
import com.easygame.sdk.repository.model.vo.backend.general.PremissionShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.RoleShowVO;

/** 登录DAO接口 */
public interface RolePermissionMapper {

	public List<Permission> selectAllPermission();

	/** 根据条件查找用户 */
	public List<RoleShowVO> selectAllRole();

	public int insertRole(RolePermissionModifyDTO record);

	public int insertRolePermissions(@Param("records") List<PremissionShowVO> records, @Param("roleId") Integer roleId);

	public RolePermissionModifyDTO selectRoleByPrimaryKey(Integer id);

	public int updateRole(RolePermissionModifyDTO record);

	public int updateRolePermissions(@Param("records") List<PremissionShowVO> records, @Param("roleId") Integer roleId);

}
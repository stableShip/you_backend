package com.easygame.sdk.controller.backend.general;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.general.RolePermissionModifyDTO;
import com.easygame.sdk.repository.model.po.Permission;
import com.easygame.sdk.repository.model.vo.backend.general.RoleShowVO;
import com.easygame.sdk.service.api.backend.general.IRolePermissionBiz;

/** 角色业务控制器 */
@Controller
@RequestMapping(value = "/backend/general/roleController")
public class RolePermissionController extends BaseController {

	@Autowired
	private IRolePermissionBiz rolePermissionBiz;

	@RequestMapping(value = "/rolePermissionAddPage", method = RequestMethod.GET)
	public String rolePermissionAddPage(ModelMap modelMap) {
		
		List<Permission> permissionList = rolePermissionBiz.selectAllPermission();
		modelMap.addAttribute("permissionList", permissionList);
		
		return "/backend/general/rolePermissionAdd";
		
	}

	@RequestMapping(value = "/rolePermissionAdd", method = RequestMethod.POST)
	public String rolePermissionAdd(RolePermissionModifyDTO role, ModelMap modelMap) {
		
		rolePermissionBiz.insertRole(role);
		
		return "redirect:/backend/general/roleController/roleList.do";
		
	}

	@RequestMapping(value = "/roleList", method = RequestMethod.GET)
	public String roleList(HttpServletRequest request, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "rolePermission");
		
		List<RoleShowVO> roleList = rolePermissionBiz.selectAllRole();
		modelMap.addAttribute("roleList", roleList);
		
		return "/backend/general/rolePermissionList";
		
	}

	@RequestMapping(value = "/rolePermissionUpdatePage", method = RequestMethod.GET)
	public String rolePermissionUpdatePage(int id, ModelMap modelMap) {
		
		RolePermissionModifyDTO role = rolePermissionBiz.selectRoleForUpdate(id);
		modelMap.addAttribute("role", role);
		
		return "/backend/general/rolePermissionUpdate";
		
	}
	
	@RequestMapping(value="/rolePermissionUpdate",method= RequestMethod.POST)
	public String rolePermissionUpdate(RolePermissionModifyDTO role, ModelMap modelMap){
		
		rolePermissionBiz.updateRole(role);
		
		return "redirect:/backend/general/roleController/roleList.do";
		
	}

}
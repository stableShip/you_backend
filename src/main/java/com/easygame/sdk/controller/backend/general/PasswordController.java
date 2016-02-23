package com.easygame.sdk.controller.backend.general;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.general.PasswordModifyDTO;
import com.easygame.sdk.service.api.backend.general.IPasswordBiz;

@Controller
@RequestMapping(value = "/backend/general/passwordController")
public class PasswordController extends BaseController {
	
	@Autowired
	private IPasswordBiz passwordBiz;
	
	@RequestMapping(value = "/passwordUpdatePage", method = RequestMethod.GET)
	public String passwordUpdatePage(HttpServletRequest request) {
		
		request.getSession().setAttribute("currentPage", "passwordPermission");
		
		return "/backend/general/changePassword";
		
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@Valid PasswordModifyDTO password, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
		
		if (bindingResult.hasErrors()) {
			
			modelMap.addAttribute("errors", bindingResult.getAllErrors());
			
			return "/backend/general/changePassword";
			
		}
		if (!password.getPassword().equals(password.getConfirmPassword())) {
			
			bindingResult.rejectValue("confirmPassword", null, "两次密码不一致");
			modelMap.addAttribute("password", password);
			modelMap.addAttribute("errors", bindingResult.getAllErrors());
			
			return "/backend/general/changePassword";
			
		}
		
		passwordBiz.updatePassword(password, getAccountID(request));
		modelMap.addAttribute("success", "success");
		
		return "/backend/general/changePassword";
	}

}
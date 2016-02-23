package com.easygame.sdk.controller.backend.general;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.general.LoginDTO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountSessionVO;
import com.easygame.sdk.service.api.backend.general.ILoginAndLogoutBiz;

/** 登录控制器 */
@Controller
@RequestMapping(value = "/backend/loginAndLogoutController")
public class LoginAndLogoutController extends BaseController {

	@Autowired
	private ILoginAndLogoutBiz loginAndLogoutBiz;

	/** 登录 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginDTO admin, HttpServletRequest request) {
		
		AccountSessionVO account = loginAndLogoutBiz.getAdmin(admin);
		
		if (account == null) {
			
			return "/backend/login";
			
		} else {
			
			request.getSession().setAttribute("account", account);
			request.getSession().setAttribute("currentPage", "");
			
			for (int i = 0; i < account.getPermissions().size(); i++) {
				
				request.getSession().setAttribute(account.getPermissions().get(i).getPageMark(), account.getPermissions().get(i).getPermissionLevel());
				
			}
			
		}
		
		return "/backend/index";
		
	}

	/** 退出 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		
		request.getSession().removeAttribute("account");
		request.getSession().removeAttribute("currentPage");
		
		return "/backend/login";
		
	}

}
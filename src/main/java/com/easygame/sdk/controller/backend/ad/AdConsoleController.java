package com.easygame.sdk.controller.backend.ad;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.controller.BaseController;

@Controller
@RequestMapping(value = "/backend/ad/adConsoleController")
public class AdConsoleController extends BaseController {

	@RequestMapping(value = "/adConsole", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String adConsole(HttpServletRequest request, ModelMap modelMap) {
		request.getSession().setAttribute("currentPage", "adConsolePermission");
		return "/backend/ad/adConsole";
	}
}

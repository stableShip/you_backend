package com.easygame.sdk.controller.backend.ad;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.controller.BaseController;

@Controller
@RequestMapping(value = "/backend/ad/adStatisticsController")
public class AdStatisticsController extends BaseController {

	@RequestMapping(value = "/adStatisticsList", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String notificationAdList(HttpServletRequest request, ModelMap modelMap) {
		request.getSession().setAttribute("currentPage", "adStatisticsPermission");
		return "/backend/ad/adStatisticsList";
	}
	
}

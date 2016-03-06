package com.easygame.sdk.controller.backend.market;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.common.util.MemcachedUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.market.AppNotificationModifyDTO;
import com.easygame.sdk.service.api.backend.market.IAppNotificationBiz;

@Controller
@RequestMapping(value = "/backend/market/notificationController")
public class AppNotificationController extends BaseController {
	
	public static final String APPNOTIFICATION = "APPNOTIFICATION";

	@Autowired
	private IAppNotificationBiz appNotificationBiz;
	
	@Autowired
	private MemcachedUtils memcachedUtils;

	@RequestMapping(value = "/appNotificationForModify", method = RequestMethod.GET)
	public String appNotificationForModifyPage(HttpServletRequest request, int id, ModelMap modelMap) {
		
		AppNotificationModifyDTO appNotification = appNotificationBiz.selectAppNotificationForUpdate(id);
		modelMap.addAttribute("appId", id);
		
		if (appNotification == null) {
			
			return "/backend/market/appNotificationAdd";
			
		} else {
			
			modelMap.addAttribute("appNotification", appNotification);
			
			return "/backend/market/appNotificationUpdate";
			
		}
	}

	@RequestMapping(value = "/appNotificationAdd", method = RequestMethod.POST)
	public String appNotificationAdd(HttpServletRequest request, AppNotificationModifyDTO appNotification) {
		
		appNotificationBiz.insertAppNotification(appNotification);
		
		return "redirect:/backend/market/appController/appList.do";
		
	}

	@RequestMapping(value = "/appNotificationUpdate", method = RequestMethod.POST)
	public String appNotificationUpdate(HttpServletRequest request, AppNotificationModifyDTO appNotification) {
		
		appNotificationBiz.updateAppNotification(appNotification);
		
		return "redirect:/backend/market/appController/appList.do";
		
	}

	@RequestMapping(value = "/appNotificationSelected", method = RequestMethod.GET)
	public String appNotificationSelected(int appId) {
		
		appNotificationBiz.updateAppNotificationSelected(appId);
		
		memcachedUtils.delete(APPNOTIFICATION);
		
		return "redirect:/backend/market/appController/appList.do";
		
	}

	@RequestMapping(value = "/appNotificationSelectedCancel", method = RequestMethod.GET)
	public String appNotificationSelectedCancel() {
		
		appNotificationBiz.updateAppNotificationSelected(0);
		
		memcachedUtils.delete(APPNOTIFICATION);
		
		return "redirect:/backend/market/appController/appList.do";
		
	}

}
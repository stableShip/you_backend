package com.easygame.sdk.controller.webservices;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.easygame.sdk.common.util.MemcachedUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.controller.backend.market.AppNotificationController;
import com.easygame.sdk.repository.model.dto.webservices.NotificationAppInformationResultDTO;
import com.easygame.sdk.service.api.backend.market.IAppNotificationBiz;

@Controller
@RequestMapping(value = "/webservice/notificationAppController")
public class NotificationAppController extends BaseController {

	@Autowired
	private IAppNotificationBiz appNotificationBiz;

	@Autowired
	private MemcachedUtils memcachedUtils;

	@RequestMapping(value = "/getNotificationAppInformation", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getNotificationAppInformation(HttpServletRequest request, String params) {
		
		String result = null;
		result = memcachedUtils.get(AppNotificationController.APPNOTIFICATION);
		
		if (result == null) {
			
			NotificationAppInformationResultDTO notificationAppinformation = appNotificationBiz.getNotificationAppInformation();
			
			if (notificationAppinformation == null) {
				
				memcachedUtils.put(AppNotificationController.APPNOTIFICATION, "null");
				
				return "null";
				
			}
			
			memcachedUtils.put(AppNotificationController.APPNOTIFICATION, JSON.toJSONString(notificationAppinformation));
			
			return JSON.toJSONString(notificationAppinformation);
			
		} else {
			
			result = memcachedUtils.get(AppNotificationController.APPNOTIFICATION);
			
			return result;
			
		}
	}

}
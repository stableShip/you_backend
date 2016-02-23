package com.easygame.sdk.controller.backend.ad;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.ad.NotificationAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.NotificationAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.NotificationAdShowVO;
import com.easygame.sdk.service.api.backend.ad.INotificationAdBiz;

@Controller
@RequestMapping(value = "/backend/ad/notificationAdController")
public class NotificationAdController extends BaseController {

	@Autowired
	private INotificationAdBiz notificationAdBiz;
	/**
	 * 根据条件查找通知栏广告并分页
	 */
	@RequestMapping(value = "/notificationAdList", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String notificationAdList(HttpServletRequest request,ModelMap modelMap, NotificationAdSearchCriteriaDTO criteria) {
		request.getSession().setAttribute("currentPage", "notificationAdPermission");
		if (criteria.getPagination() == null) {
			criteria.setPagination(new Page());
		}
		List<NotificationAdShowVO> notificationAdList = notificationAdBiz.selectNotificationAdListByCriteria(criteria);
		criteria.getPagination().setTotalCount(notificationAdBiz.getNotificationAdListTotalCountByCriteria(criteria));
		modelMap.addAttribute("notificationAdList", notificationAdList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		return "/backend/ad/notificationAdList";
	}
	/**
	 * 跳转到通知栏广告添加页面
	 */
	@RequestMapping(value = "/notificationAdAddPage", method = RequestMethod.GET)
	public String notificationAdAddPage() {
		return "/backend/ad/notificationAdAdd";
	}
	/**
	 * 添加通知栏广告
	 */
	
	@RequestMapping(value = "/notificationAdAdd", method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String notificationAdAdd(NotificationAdModifyDTO notificationAd,HttpServletRequest request,BindingResult bindingResult) {
	    
	    JSONObject result = new JSONObject();
		
		
		if (notificationAd.getName() == null || "".equals(notificationAd.getName())) {
			
			Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
			
			String mess = getApplicationContext().getMessage("backend.admin.list.column.remarks", null, locale);
			bindingResult.rejectValue("name",null, mess);
			
		}

		if (notificationAdBiz.checkNotificationAdDuplication(notificationAd.getName(), 0) > 0) {
	
			bindingResult.rejectValue("name", null, "广告已经存在");
	
		}
		if (bindingResult.hasErrors()) {
			
			result.put("errors", bindingResult.getAllErrors());
			
		} else {
			
			notificationAdBiz.insertNotificationAd(notificationAd);
		}
		result.put("notificationAd",notificationAd);
		return JSON.toJSONString(result);
	
	}
	/**
	 * 跳转到通知栏广告修改页面
	 */
	@RequestMapping(value="/notificationAdUpdatePage",method=RequestMethod.GET)
	public String notificationAdUpdatePage(int id,ModelMap modelMap) {
	    	NotificationAdShowVO notificationAd=notificationAdBiz.selectNotificationAdAdForUpdate(id);
	    	modelMap.addAttribute("notificationAd", notificationAd);
		return "/backend/ad/notificationAdUpdate";
	}
	/**
	 * 修改通知栏广告
	 */
	@RequestMapping(value="/notificationAdUpdate",method=RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String notificationAdUpdate(@Valid NotificationAdModifyDTO notificationAd,BindingResult bindingResult) {
	    	JSONObject result = new JSONObject();

		if (notificationAdBiz.checkNotificationAdDuplication(notificationAd.getName(), notificationAd.getId()) > 0) {
			
			bindingResult.rejectValue("name", null, "广告已经存在");
			
		} 
		if (bindingResult.hasErrors()) {
			
			List<ObjectError> fieldErrors = bindingResult.getAllErrors();
			result.put("errors", fieldErrors);
			
		} else{
		    notificationAdBiz.updateNotificationAd(notificationAd);
		}
		
		result.put("notificationAd", notificationAd);
		
		return JSON.toJSONString(result);
	    
	}
	/**
	 * 删除通知栏广告
	 */
	@RequestMapping(value = "/notificationAdDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String notificationAdDelete(int id) {
		int success = notificationAdBiz.deleteNotificationAd(id);
		return success + "";
	}

}
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
import com.easygame.sdk.common.util.ValidationUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.ad.ScreenAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.ScreenAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.ScreenAdShowVO;
import com.easygame.sdk.service.api.backend.ad.IScreenAdBiz;

@Controller
@RequestMapping(value = "/backend/ad/screenAdController")
public class ScreenAdController extends BaseController{
	
	@Autowired
	private IScreenAdBiz screenAdBiz;
	/**
	 * 根据条件查找插屏广告并分页
	 */
	@RequestMapping(value = "/screenAdList", method = { RequestMethod.GET,RequestMethod.POST })
	public String batchList(HttpServletRequest request, ModelMap modelMap,ScreenAdSearchCriteriaDTO criteria) {
		
		request.getSession().setAttribute("currentPage", "screenAdPermission");
		
		if (criteria.getPagination() == null) {
			criteria.setPagination(new Page());
		}
		
		List<ScreenAdShowVO> screenAdList= screenAdBiz.selectScreenAdListByCriteria(criteria);
		criteria.getPagination().setTotalCount(screenAdBiz.getScreenAdListTotalCountByCriteria(criteria));
		
		modelMap.addAttribute("screenAdList", screenAdList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		
		return "/backend/ad/screenAdList";
	}

	/**
	 * 跳转到插屏广告添加页面
	 */
	@RequestMapping(value = "/screenAdAddPage", method = RequestMethod.GET)
	public String screenAdAddPage() {
		return "/backend/ad/screenAdAdd";
	}
	
	/**
	 * 添加插屏广告
	 */
	
	@RequestMapping(value="/screenAdAdd",method= RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String screenAdAdd(@Valid ScreenAdModifyDTO screenAd,HttpServletRequest request,BindingResult bindingResult){
		JSONObject result = new JSONObject();
		Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
		
		ValidationUtils.checkStringFieldNullOrEmpty("name", getApplicationContext().getMessage("backend.screenAd.modify.errorMessage.name.empty", null, locale), bindingResult);
		
		if (screenAd.getName() == null || "".equals(screenAd.getName())) {
			
			String mess = getApplicationContext().getMessage("backend.admin.list.column.remarks", null, locale);
			bindingResult.rejectValue("name",null, mess);
			
		}

		if (screenAdBiz.checkScreenAdDuplication(screenAd.getName(), 0) > 0) {
	
			bindingResult.rejectValue("name", null, "广告已经存在");
	
		}
		if (bindingResult.hasErrors()) {
			
			result.put("errors", bindingResult.getAllErrors());
			
		} else {
			
			screenAdBiz.insertScreenAd(screenAd);
		}
		result.put("screenAd",screenAd);
		System.out.println(JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
	
	/**
	 * 删除插屏广告
	 */
	
	@RequestMapping(value = "/screenAdDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String screenAdDelete(int id) {
		int success = screenAdBiz.deleteScreenAd(id);
		return success + "";
	}
	
	/**
	 * 跳转到插屏广告修改页面
	 */
	@RequestMapping(value = "/screenAdUpdatePage", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String screenAdUpdatePage(int id, ModelMap modelMap) {
		modelMap.put("screenAd", screenAdBiz.selectScreenAdForUpdate(id));
		return "/backend/ad/screenAdUpdate";
	}
	
	/**
	 *  更新插屏广告
	 */
	@RequestMapping(value = "/screenAdUpdate", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String screenAdUpdate(@Valid ScreenAdModifyDTO screenAd,BindingResult bindingResult) {
		JSONObject result = new JSONObject();
		
		if (screenAdBiz.checkScreenAdDuplication(screenAd.getName(), screenAd.getId()) > 0) {
			
			bindingResult.rejectValue("name", null, "广告已经存在");
			
		}
		if (bindingResult.hasErrors()) {
			
			List<ObjectError> fieldErrors = bindingResult.getAllErrors();
			result.put("errors", fieldErrors);
			
		} else{
			screenAdBiz.updateScreenAd(screenAd);
		}
		
		result.put("screenAd", screenAd);
		return JSON.toJSONString(result);
	}

	
}

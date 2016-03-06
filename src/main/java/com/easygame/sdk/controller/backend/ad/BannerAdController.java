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
import com.easygame.sdk.repository.model.dto.backend.ad.BannerAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.BannerAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.BannerAdShowVO;
import com.easygame.sdk.service.api.backend.ad.IBannerAdBiz;

@Controller
@RequestMapping(value = "/backend/ad/bannerAdController")
public class BannerAdController extends BaseController{
	
	@Autowired
	private IBannerAdBiz bannerAdBiz;
	/**
	 * 根据条件查找bannerAd并分页
	 */
	@RequestMapping(value = "/bannerAdList", method = { RequestMethod.GET,RequestMethod.POST })
	public String batchList(HttpServletRequest request, ModelMap modelMap,BannerAdSearchCriteriaDTO criteria) {
		
		request.getSession().setAttribute("currentPage", "bannerAdPermission");
		
		if (criteria.getPagination() == null) {
			criteria.setPagination(new Page());
		}
		
		List<BannerAdShowVO> bannerAdList= bannerAdBiz.selectBannerAdListByCriteria(criteria);
		criteria.getPagination().setTotalCount(bannerAdBiz.getBannerAdListTotalCountByCriteria(criteria));
		
		modelMap.addAttribute("bannerAdList", bannerAdList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		
		return "/backend/ad/bannerAdList";
	}

	
	@RequestMapping(value = "/bannerAdAddPage", method = RequestMethod.GET)
	public String bannerAdAddPage() {
		return "/backend/ad/bannerAdAdd";
	}
	
	/**
	 * 添加bannerAd
	 */
	
	@RequestMapping(value="/bannerAdAdd",method= RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String bannerAdAdd(@Valid BannerAdModifyDTO bannerAd,HttpServletRequest request,BindingResult bindingResult){
		JSONObject result = new JSONObject();
		Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
		
		ValidationUtils.checkStringFieldNullOrEmpty("name", getApplicationContext().getMessage("backend.bannerAd.add.err-message.name", null, locale), bindingResult);
		
		if (bannerAd.getName() == null || "".equals(bannerAd.getName())) {
			
			String mess = getApplicationContext().getMessage("backend.admin.list.column.remarks", null, locale);
			bindingResult.rejectValue("name",null, mess);
			
		}

		if (bannerAdBiz.checkBannerAdDuplication(bannerAd.getName(), 0) > 0) {
	
			bindingResult.rejectValue("name", null, "广告已经存在");
	
		}
		if (bindingResult.hasErrors()) {
			
			result.put("errors", bindingResult.getAllErrors());
			
		} else {
			
			bannerAdBiz.insertBannerAd(bannerAd);
		}
		result.put("bannerAd",bannerAd);
		System.out.println(JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	
	
	/**
	 * 删除bannerAd
	 */
	
	@RequestMapping(value = "/bannerAdDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String bannerAdDelete(int id) {
		int success = bannerAdBiz.deleteBannerAd(id);
		return success + "";
	}
	
	
	@RequestMapping(value = "/bannerAdUpdatePage", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String bannerAdUpdatePage(int id, ModelMap modelMap) {
		modelMap.put("bannerAd", bannerAdBiz.selectBannerAdForUpdate(id));
		return "/backend/ad/bannerAdUpdate";
	}
	
	/**
	 *  更新bannerAd
	 */
	@RequestMapping(value = "/bannerAdUpdate", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String bannerAdUpdate(@Valid BannerAdModifyDTO bannerAd,BindingResult bindingResult) {
		JSONObject result = new JSONObject();
		
		if (bannerAdBiz.checkBannerAdDuplication(bannerAd.getName(), bannerAd.getId()) > 0) {
			
			bindingResult.rejectValue("name", null, "广告已经存在");
			
		}
		if (bindingResult.hasErrors()) {
			
			List<ObjectError> fieldErrors = bindingResult.getAllErrors();
			result.put("errors", fieldErrors);
			
		} else{
			bannerAdBiz.updateBannerAd(bannerAd);
		}
		
		result.put("bannerAd", bannerAd);
		return JSON.toJSONString(result);
	}

	
}

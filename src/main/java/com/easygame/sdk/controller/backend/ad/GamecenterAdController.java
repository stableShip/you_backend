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
import com.easygame.sdk.repository.model.dto.backend.ad.GamecenterAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.GamecenterAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.GamecenterAdShowVO;
import com.easygame.sdk.service.api.backend.ad.IGamecenterAdBiz;

@Controller
@RequestMapping(value = "/backend/ad/gamecenterAdController")
public class GamecenterAdController extends BaseController {

	@Autowired
	private IGamecenterAdBiz gamecenterAdBiz;
	/**
	 * 根据条件查找游戏中心广告并分页
	 */
	@RequestMapping(value = "/gamecenterAdList", method = {RequestMethod.GET, RequestMethod.POST })
	public String gamecenterAdList(HttpServletRequest request,ModelMap modelMap, GamecenterAdSearchCriteriaDTO criteria) {
		request.getSession().setAttribute("currentPage", "gamecenterAdPermission");
		if (criteria.getPagination() == null) {
		    criteria.setPagination(new Page());
		}
		List<GamecenterAdShowVO> gamecenterAdList = gamecenterAdBiz.selectGamecenterAdListByCriteria(criteria);
		criteria.getPagination().setTotalCount(gamecenterAdBiz.getGamecenterAdListTotalCountByCriteria(criteria));
		modelMap.addAttribute("gamecenterAdList", gamecenterAdList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		return "/backend/ad/gamecenterAdList";
	}
	
	/**
	 * 跳转到游戏中心广告添加页面
	 */
	@RequestMapping(value = "/gamecenterAdAddPage", method = RequestMethod.GET)
	public String gamecenterAdAddPage() {
		return "/backend/ad/gamecenterAdAdd";
	}
	/**
	 * 添加游戏中心广告
	 */
	@RequestMapping(value = "/gamecenterAdAdd", method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String gamecenterAdAdd(GamecenterAdModifyDTO gamecenterAd,HttpServletRequest request,BindingResult bindingResult) {
	    		JSONObject result = new JSONObject();
		if (gamecenterAd.getName() == null || "".equals(gamecenterAd.getName())) {
		  	
		    Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
		    String mess = getApplicationContext().getMessage("backend.admin.list.column.remarks", null, locale);
		    bindingResult.rejectValue("name",null, mess);
		}

		if (gamecenterAdBiz.checkGamecenterAdDuplication(gamecenterAd.getName(), 0) > 0) {
	
		    bindingResult.rejectValue("name", null, "广告已经存在");
	
		}
		if (bindingResult.hasErrors()) {
			
		    result.put("errors", bindingResult.getAllErrors());
			
		} else {
		    gamecenterAdBiz.insertGamecenterAd(gamecenterAd);
		}
		result.put("gamecenterAd",gamecenterAd);
		return JSON.toJSONString(result);
	
	}
	/**
	 * 跳转到游戏中心广告修改页面
	 */
	@RequestMapping(value="/gamecenterAdUpdatePage",method=RequestMethod.GET)
	public String gamecenterAdUpdatePage(int id,ModelMap modelMap) {
	    	GamecenterAdShowVO gamecenterAd=gamecenterAdBiz.selectGamecenterAdForUpdate(id);
	    	modelMap.addAttribute("gamecenterAd", gamecenterAd);
		return "/backend/ad/gamecenterAdUpdate";
	}
	/**
	 * 修改游戏中心广告
	 */
	@RequestMapping(value="/gamecenterAdUpdate",method=RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String gamecenterAdUpdate(@Valid GamecenterAdModifyDTO gamecenterAd,BindingResult bindingResult) {
	    		JSONObject result = new JSONObject();
		if (gamecenterAdBiz.checkGamecenterAdDuplication(gamecenterAd.getName(), gamecenterAd.getId()) > 0) {
			
			bindingResult.rejectValue("name", null, "广告已经存在");
			
		} 
		if (bindingResult.hasErrors()) {
			
			List<ObjectError> fieldErrors = bindingResult.getAllErrors();
			result.put("errors", fieldErrors);
			
		} else{
		    gamecenterAdBiz.updateGamecenterAd(gamecenterAd);
		}
		
		result.put("gamecenterAd", gamecenterAd);
		
		return JSON.toJSONString(result);
	    
	}
	/**
	 * 删除游戏中心广告
	 */
	@RequestMapping(value = "/gamecenterAdDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String gamecenterAdDelete(int id) {
		int success = gamecenterAdBiz.deleteGamecenterAd(id);
		return success + "";
	}
	
	/**
	 * 跳转到游戏中心广告显示顺序
	 */
	@RequestMapping(value = "/changeShowIndex", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String changeShowIndex(GamecenterAdModifyDTO gamecenterAd){
	    int success=gamecenterAdBiz.updateShowIndex(gamecenterAd);
	    return success + "";
	}

}
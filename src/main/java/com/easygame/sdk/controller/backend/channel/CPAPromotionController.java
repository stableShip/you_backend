package com.easygame.sdk.controller.backend.channel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionShowVO;
import com.easygame.sdk.repository.model.vo.backend.channel.ChannelShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountSessionVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppShowVO;
import com.easygame.sdk.service.api.backend.channel.ICPAPromotionBIz;

@Controller
@RequestMapping(value = "/backend/channel/cpaPromotionController")
public class CPAPromotionController extends BaseController {

	@Autowired
	private ICPAPromotionBIz cpaPromotionBiz;

	@RequestMapping(value = "/cpaPromotionAddPage", method = RequestMethod.GET)
	public String cpaPromotionAddPage(HttpServletRequest request, ModelMap modelMap) {
		
		List<ChannelShowVO> channelList = cpaPromotionBiz.selectAllChannel();
		List<AppShowVO> appList = cpaPromotionBiz.selectAllApp();
		
		modelMap.addAttribute("channelList", channelList);
		modelMap.addAttribute("appList", appList);
		
		return "/backend/channel/cpaPromotionAdd";
		
	}

	@RequestMapping(value = "/cpaPromotionAdd", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String cpaPromotionAdd(@Valid CPAPromotionModifyDTO promotion, BindingResult bindingResult, HttpServletRequest request) {
		
		JSONObject result = new JSONObject();
		
		if (promotion.getChannelId() == null) {
			
			bindingResult.rejectValue("channelId", null, "请先创建一个渠道");
			
		} else if (promotion.getAppId() == null) {
			
			bindingResult.rejectValue("appId", null, "请先创建一个应用");
			
		} else {
			
			if (cpaPromotionBiz.checkPromotionDuplication(promotion) > 0) {
				
				bindingResult.rejectValue("appNickName", null, "已经存在相同渠道、应用、应用别名的推广");
				
			}
			
		}
		
		if (promotion.getSameDayPrice() == null) {
			
			bindingResult.rejectValue("sameDayPrice", null, "请输入有效激活价格");
			
		}
		
		if (promotion.getNextDayPrice() == null) {
			
			bindingResult.rejectValue("nextDayPrice", null, "请输入次日留存价格");
			
		}
		
		if (!bindingResult.hasErrors()) {
			
			AccountSessionVO account = (AccountSessionVO) request.getSession().getAttribute("account");
			promotion = cpaPromotionBiz.insertPromotion(promotion, account.getId());
			
		} else {
			
			result.put("errors", bindingResult.getAllErrors());
			
		}
		
		result.put("promotion", promotion);
		
		return JSON.toJSONString(result);
		
	}

	@RequestMapping(value = "/cpaPromotionUpdatePage", method = RequestMethod.GET)
	public String cpaPromotionUpdatePage(HttpServletRequest request, int id, ModelMap modelMap) {
		
		CPAPromotionModifyDTO promotion = cpaPromotionBiz.selectPromotionForUpdate(id);
		modelMap.addAttribute("promotion", promotion);
		
		return "/backend/channel/cpaPromotionUpdate";
	}

	@RequestMapping(value = "/cpaPromotionUpdate", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String cpaPromotionUpdate(@Valid CPAPromotionModifyDTO promotion, BindingResult bindingResult, HttpServletRequest request) {
		
		JSONObject result = new JSONObject();
		
		if (cpaPromotionBiz.checkPromotionDuplication(promotion) > 0) {
			
			bindingResult.rejectValue("appNickName", null, "已经存在相同渠道、应用、应用别名的推广");
			
		}
		
		if (promotion.getSameDayPrice() == null) {
			
			bindingResult.rejectValue("sameDayPrice", null, "请输入有效激活价格");
			
		}
		
		if (promotion.getNextDayPrice() == null) {
			
			bindingResult.rejectValue("nextDayPrice", null, "请输入次日留存价格");
			
		}
		
		if (!bindingResult.hasErrors()) {
			
			AccountSessionVO account = (AccountSessionVO) request.getSession().getAttribute("account");
			promotion = cpaPromotionBiz.updatePromotion(promotion, account.getId());
			
		} else {
			
			result.put("errors", bindingResult.getAllErrors());
			
		}
		
		result.put("promotion", promotion);
		
		return JSON.toJSONString(result);
		
	}

	@RequestMapping(value = "/cpaPromotionList", method = { RequestMethod.POST, RequestMethod.GET })
	public String cpaPromotionList(CPAPromotionSearchCriteriaDTO criteria, HttpServletRequest request, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "cpaPromotionPermission");
		
		if (criteria.getPagination() == null) {
			
			criteria.setPagination(new Page());
			
		}
		
		List<CPAPromotionShowVO> promotionList = cpaPromotionBiz.selectPromotionListByCriteria(criteria);
		criteria.getPagination().setTotalCount(cpaPromotionBiz.getPromotionListTotalCountByCriteria(criteria));
		request.getSession().setAttribute("promotionList", promotionList);
		
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		
		return "/backend/channel/cpaPromotionList";
		
	}

	@RequestMapping(value = "/cpaPromotionDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String cpaPromotionDelete(int id, HttpServletRequest request) {
		
		AccountSessionVO account = (AccountSessionVO) request.getSession().getAttribute("account");
		
		return cpaPromotionBiz.deletePromotion(id, account.getId()) + "";
		
	}

}
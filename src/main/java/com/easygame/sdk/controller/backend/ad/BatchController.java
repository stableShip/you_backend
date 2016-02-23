package com.easygame.sdk.controller.backend.ad;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.service.api.backend.ad.IBatchBiz;

@Controller
@RequestMapping(value = "/backend/ad/batchController")
public class BatchController extends BaseController {

	@Autowired
	private IBatchBiz batchBiz;
	
	@RequestMapping(value = "/batchList", method = { RequestMethod.GET, RequestMethod.POST })
	public String batchList(HttpServletRequest request, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "batchPermission");
		
		return "/backend/ad/batchList";
		
	}

	@RequestMapping(value = "/batchAddPage", method = RequestMethod.GET)
	public String addBatchPage(ModelMap modelMap) {
		
		modelMap.addAttribute("channelList", batchBiz.getChannelList());
		
		return "/backend/ad/batchAdd";
		
	}
	
	/** 获取应用 */
	@RequestMapping(value = "/getAppOptions", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getAppOptions(HttpServletRequest request, Integer channelId) {
		
		return JSON.toJSONString(batchBiz.getAppList(channelId));
		
	}
	
	/** 获取别名 */
	@RequestMapping(value = "/getCpaAppOptions", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getCpaAppOptions(HttpServletRequest request, Integer channelId, Integer appId) {
		
		return JSON.toJSONString(batchBiz.getCpaAppList(channelId, appId));
		
	}
	
	/** 获取CPA信息 */
	@RequestMapping(value = "/getCpaPromotionRecord", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getCpaPromotionRecord(Integer cpaId) {
		
		return JSON.toJSONString(batchBiz.getCpaPromotionVO(cpaId));
		
	}

}

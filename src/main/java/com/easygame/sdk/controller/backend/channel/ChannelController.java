package com.easygame.sdk.controller.backend.channel;

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
import com.easygame.sdk.repository.model.dto.backend.channel.ChannelModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.channel.ChannelSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.ChannelShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountShowVO;
import com.easygame.sdk.service.api.backend.channel.IChannelBiz;

@Controller
@RequestMapping(value = "/backend/channel/channelController")
public class ChannelController extends BaseController {

	@Autowired
	private IChannelBiz channelBiz;
	
	@RequestMapping(value = "/findChannel", method = { RequestMethod.GET, RequestMethod.POST })
	public String findChannel(ChannelSearchCriteriaDTO criteria, HttpServletRequest request, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "channelPermission");
		
		if (criteria.getPagination() == null) {
			criteria.setPagination(new Page());
		}
		
		List<ChannelShowVO> channelList = channelBiz.selectChannelListByCriteria(criteria);
		criteria.getPagination().setTotalCount(channelBiz.getChannelListTotalCountByCriteria(criteria));
		
		modelMap.addAttribute("channelList", channelList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		
		return "/backend/channel/channelList";
		
	}

	@RequestMapping(value = "/channelAddPage", method = RequestMethod.GET)
	public String channelAddPage(ModelMap modelMap) {
		
		List<AccountShowVO> adminList = channelBiz.selectAllAdmin();
		List<ChannelShowVO> channelList = channelBiz.selectAllChannel();
		
		modelMap.addAttribute("adminList", adminList);
		modelMap.addAttribute("channelList", channelList);
		
		return "/backend/channel/channelAdd";
		
	}

	@RequestMapping(value = "/channelAdd", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String channelAdd(HttpServletRequest request, @Valid ChannelModifyDTO channel, BindingResult bindingResult) {
		
		JSONObject result = new JSONObject();
		
		if (channel.getName() == null || "".equals(channel.getName())) {
			
			Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
			
			String mess = getApplicationContext().getMessage("backend.admin.list.column.remarks", null, locale);
			bindingResult.rejectValue("name",null, mess);
			
		}
		
		if (channelBiz.checkChannelDuplication(channel.getName(), 0) > 0) {
			
			bindingResult.rejectValue("name", null, "渠道已经存在");
			
		}
		
		if (bindingResult.hasErrors()) {
			
			result.put("errors", bindingResult.getAllErrors());
			
		} else {
			
			channel = channelBiz.insertChannel(channel);
		}
		
		result.put("channel", channel);
		
		return JSON.toJSONString(result);
		
	}

	@RequestMapping(value = "/channelUpdatePage", method = { RequestMethod.GET, RequestMethod.POST })
	public String channelUpdatePage(int id, ModelMap modelMap) {
		
		List<AccountShowVO> adminList = channelBiz.selectAllAdmin();
		ChannelModifyDTO channel = channelBiz.selectChannelForUpdate(id);
		List<ChannelShowVO> channelList = channelBiz.selectAllChannel();
		
		modelMap.addAttribute("adminList", adminList);
		modelMap.addAttribute("channel", channel);
		modelMap.addAttribute("channelList", channelList);
		
		return "/backend/channel/channelUpdate";
		
	}

	@RequestMapping(value = "/channelUpdate", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String channelUpdate(@Valid ChannelModifyDTO channel, BindingResult bindingResult) {
		
		JSONObject result = new JSONObject();
		
		if (channelBiz.checkChannelDuplication(channel.getName(), channel.getId()) > 0) {
			
			bindingResult.rejectValue("name", null, "渠道已经存在");
			
		}
		
		if (bindingResult.hasErrors()) {
			
			List<ObjectError> fieldErrors = bindingResult.getAllErrors();
			result.put("errors", fieldErrors);
			
		} else {
			
			channel = channelBiz.updateChannel(channel);
			
		}
		
		result.put("channel", channel);
		
		return JSON.toJSONString(result);
		
	}

	@RequestMapping(value = "/channelDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String channelDelete(int id) {
		
		int success = channelBiz.deleteChannel(id);
		
		return success + "";
		
	}

}

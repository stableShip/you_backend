package com.easygame.sdk.controller.webservices;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.easygame.sdk.common.util.InternetUtils;
import com.easygame.sdk.common.util.JSONUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.ScreenAdResultVO;
import com.easygame.sdk.service.api.webservices.IScreenAdServiceBiz;

@Controller
@RequestMapping(value = "/webservice/screenAdServiceController")
public class ScreenAdServiceController extends BaseController {
	
	@Autowired
	private IScreenAdServiceBiz screenAdServiceBiz;

	@RequestMapping(value = "/getScreenAdInformation", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getScreenAdInformation(HttpServletRequest request, String params) {
		
//		params = "{\"appKey\":\"d31d07a0b0615ca3180314dd230247a3\",\"imei\":\"b\"}";
		if (params == null || "".equals(params)) {
			return "0";
		}
		
		AdParamsDTO paramObject = null;
		ScreenAdResultVO result = null;
		
		try {
			
			paramObject = JSONUtils.objectMapper.readValue(params, AdParamsDTO.class);
			result = screenAdServiceBiz.getScreenAdInformation(paramObject, InternetUtils.getIPAddress(request));
			
		} catch (JsonParseException e) {
			e.printStackTrace();
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return JSON.toJSONString(result);
		
	}
	
	@RequestMapping(value = "/clickScreenAd", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String clickScreenAd(HttpServletRequest request, String params) {
			
//		params = "{\"appKey\":\"d31d07a0b0615ca3180314dd230247a3\",\"imei\":\"b\",\"adId\":\"1\"}";
		int isSuccess = 0;
		if (params == null || "".equals(params)) {
			return isSuccess + "";
		}
		
		AdParamsDTO paramObject = null;
		try {
			
			paramObject = JSONUtils.objectMapper.readValue(params, AdParamsDTO.class);
			isSuccess = screenAdServiceBiz.insertScreenAdClickRecord(paramObject, InternetUtils.getIPAddress(request));
			
		} catch (JsonParseException e) {
			e.printStackTrace();
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return isSuccess + "";
		
	}
	
	@RequestMapping(value = "/finishScreenAdDownload", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String finishScreenAdDownload(HttpServletRequest request, String params) {
			
//		params = "{\"appKey\":\"d31d07a0b0615ca3180314dd230247a3\",\"imei\":\"b\",\"adId\":\"1\"}";
		int isSuccess = 0;
		if (params == null || "".equals(params)) {
			return isSuccess + "";
		}
		
		AdParamsDTO paramObject = null;
		try {
			
			paramObject = JSONUtils.objectMapper.readValue(params, AdParamsDTO.class);
			isSuccess = screenAdServiceBiz.insertScreenAdClickRecord(paramObject, InternetUtils.getIPAddress(request));
			
		} catch (JsonParseException e) {
			e.printStackTrace();
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return isSuccess + "";
		
	}
	
}

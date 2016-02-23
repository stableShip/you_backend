package com.easygame.sdk.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.easygame.sdk.repository.model.vo.backend.general.AccountSessionVO;

public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected ServletContext servletContext; 
	
	protected void showJSONObject(Object object) {
		
		logger.debug(JSON.toJSONString(object));
		
	}

	protected Integer getAccountID(HttpServletRequest request) {
		
		AccountSessionVO account = (AccountSessionVO) request.getSession().getAttribute("account");
		
		return account.getId();
		
	}
	
	protected WebApplicationContext getApplicationContext() {
		
		return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext); 
		
	}
	
}

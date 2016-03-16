package com.easygame.sdk.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 后台session过滤器 */
public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("account") == null) {
			
			response.sendRedirect(request.getContextPath() + "/index");
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}

}
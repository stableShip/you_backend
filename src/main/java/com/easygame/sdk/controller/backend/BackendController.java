package com.easygame.sdk.controller.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BackendController {

	@RequestMapping(value = "/backend/showmethebackend", method = RequestMethod.GET)
	public String login() {
		
		return "/backend/login";
		
	}
}

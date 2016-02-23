package com.easygame.sdk.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.controller.BaseController;

@Controller
public class HomepageController extends BaseController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		
		return "/frontend/index";
		
	}

}

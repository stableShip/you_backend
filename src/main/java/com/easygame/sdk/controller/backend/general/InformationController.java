package com.easygame.sdk.controller.backend.general;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.general.InformationModifyDTO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountSessionVO;
import com.easygame.sdk.service.api.backend.general.IInformationBiz;

/** 修改个人信息控制器 */
@Controller
@RequestMapping(value = "/backend/general/informationController")
public class InformationController extends BaseController {

	@Autowired
	private IInformationBiz informationBiz;

	/** 跳转到修改个人信息页面 */
	@RequestMapping(value = "/informationUpdatePage", method = RequestMethod.GET)
	public String informationUpdatePage(HttpServletRequest request, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "informationPermission");
		
		AccountSessionVO account = (AccountSessionVO) request.getSession().getAttribute("account");
		InformationModifyDTO information = informationBiz.selectAccountForUpdate(account.getId());
		
		modelMap.addAttribute("information", information);
		
		return "/backend/general/changeInformation";
	}

	/** 更新个人信息 */
	@RequestMapping(value = "/informationUpdate", method = RequestMethod.POST)
	public String informationUpdate(HttpServletRequest request, @Valid InformationModifyDTO information, BindingResult bindingResult, ModelMap modelMap) {
		
		if (bindingResult.hasErrors()) {
			
			modelMap.addAttribute("information", information);
			modelMap.addAttribute("errors", bindingResult.getAllErrors());
			
			return "/backend/system/changeInformation";
			
		}
		
		information.setId(getAccountID(request));
		informationBiz.updateAccount(information);
		
		modelMap.addAttribute("success", "success");
		modelMap.addAttribute("information", information);
		
		return "/backend/general/changeInformation";
		
	}

}

package com.easygame.sdk.controller.backend.general;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.alibaba.fastjson.JSON;
import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.common.util.ValidationUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.general.CompanyModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.general.CompanySearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;
import com.easygame.sdk.service.api.backend.general.ICompanyBiz;

/** 公司业务控制器 */
@Controller
@RequestMapping(value = "/backend/general/companyController")
public class CompanyController extends BaseController {

	@Autowired
	private ICompanyBiz companyBiz;

	/** 跳转到添加公司页面 */
	@RequestMapping(value = "/companyAddPage", method = RequestMethod.GET)
	public String companyAddPage(HttpServletRequest request, ModelMap modelMap) {
		
		return "/backend/general/companyAdd";
		
	}

	/** 添加公司 */
	@RequestMapping(value = "/companyAdd", method = RequestMethod.POST)
	public String companyAdd(HttpServletRequest request, CompanyModifyDTO company, BindingResult bindingResult, ModelMap modelMap) {
		
		Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
		
		ValidationUtils.checkStringFieldNullOrEmpty("name", getApplicationContext().getMessage("backend.company.modify.errorMessage.name.empty", null, locale), bindingResult);
		
		if (companyBiz.checkCompanyDuplication(company) > 0) {
			
			bindingResult.rejectValue("name", null, getApplicationContext().getMessage("backend.company.modify.errorMessage.name.duplicate", null, locale));
			
		}
		
		if (bindingResult.hasErrors()) {
			
			modelMap.addAttribute("company", company);
			modelMap.addAttribute("errors", bindingResult.getAllErrors());
			
			return "/backend/general/companyAdd";
			
		}
		
		companyBiz.insertCompany(company);
		
		return "redirect:/backend/general/companyController/companyList.do";
		
	}

	/** 跳转到更新公司页面 */
	@RequestMapping(value = "/companyUpdatePage", method = RequestMethod.GET)
	public String companyUpdatePage(HttpServletRequest request,  ModelMap modelMap, int id) {
		
		CompanyModifyDTO company = companyBiz.selectCompanyForUpdate(id);
		modelMap.addAttribute("company", company);
		
		return "/backend/general/companyUpdate";
		
	}

	/** 更新公司信息 */
	@RequestMapping(value = "/companyUpdate", method = RequestMethod.POST)
	public String companyUpdate(HttpServletRequest request, @Valid CompanyModifyDTO company, BindingResult bindingResult, ModelMap modelMap) {
		
		if (companyBiz.checkCompanyDuplication(company) > 0) {
			
			bindingResult.rejectValue("code", null, "已经存在相同公司代码与公司名称的公司");
			
		}
		
		if (bindingResult.hasErrors()) {
			
			modelMap.addAttribute("company", company);
			modelMap.addAttribute("errors", bindingResult.getAllErrors());
			
			return "/backend/system/companyUpdate";
			
		}
		
		companyBiz.updateCompany(company);
		
		return "redirect:/backend/general/companyController/companyList.do";
		
	}

	/** 查找公司 */
	@RequestMapping(value = "/companyList", method = { RequestMethod.GET, RequestMethod.POST })
	public String findCompany(HttpServletRequest request, CompanySearchCriteriaDTO criteria, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "companyPermission");
		
		if (criteria.getPagination() == null) {
			
			criteria.setPagination(new Page());
			
		}
		
		List<CompanyShowVO> companyList = companyBiz.selectCompanyListByCriteria(criteria);
		criteria.getPagination().setTotalCount(companyBiz.getCompanyListTotalCountByCriteria(criteria));
		
		modelMap.addAttribute("companyList", companyList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		
		return "/backend/general/companyList";
		
	}

	/** 删除公司 */
	@RequestMapping(value = "/companyDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String companyDelete(HttpServletRequest request, int id) {
		
		int success = companyBiz.deleteCompanyByPrimaryKey(id);
		
		return success + "";
		
	}

	/** 查看公司信息 */
	@RequestMapping(value = "/viewDetail", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String viewDetailByJSON(int id) {
		
		CompanyModifyDTO company = companyBiz.selectCompanyForUpdate(id);
		
		return JSON.toJSONString(company);
		
	}

}
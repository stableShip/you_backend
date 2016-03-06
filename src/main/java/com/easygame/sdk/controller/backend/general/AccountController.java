package com.easygame.sdk.controller.backend.general;

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
import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.common.util.ValidationUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.general.AccountModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.general.AccountSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountSessionVO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.RoleShowVO;
import com.easygame.sdk.service.api.backend.general.IAccountBiz;
import com.easygame.sdk.service.api.backend.general.IRolePermissionBiz;

/** 账号业务控制器 */
@Controller
@RequestMapping(value = "/backend/general/accountController")
public class AccountController extends BaseController {

	@Autowired
	private IAccountBiz accountBiz;
	
	@Autowired
	private IRolePermissionBiz rolePermissionBiz;

	/** 跳转到添加账号页面 */
	@RequestMapping(value = "/accountAddPage", method = RequestMethod.GET)
	public String accountAddPage(HttpServletRequest request, Integer companyId, ModelMap modelMap) {
		
		List<CompanyShowVO> companyList = accountBiz.selectAllCompany();
		List<RoleShowVO> roleList = rolePermissionBiz.selectAllRole();
		
		modelMap.addAttribute("companyId", companyId);
		modelMap.addAttribute("companyList", companyList);
		modelMap.addAttribute("roleList", roleList);
		
		return "/backend/general/accountAdd";
		
	}

	/** 添加账号 */
	@RequestMapping(value = "/accountAdd", method = RequestMethod.POST)
	public String accountAdd(HttpServletRequest request, @Valid AccountModifyDTO dto, BindingResult bindingResult, ModelMap modelMap) {
		
		ValidationUtils.checkStringFieldNullOrEmpty("account", "账号不能为空", bindingResult);
		
		if (accountBiz.checkAccountDuplication(dto) > 0) {
			
			bindingResult.rejectValue("account", null, "已经存在相同账号用户");
		}
		
		ValidationUtils.checkStringFieldNullOrEmpty("password", "密码不能为空", bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			modelMap.addAttribute("dto", dto);
			modelMap.addAttribute("errors", bindingResult.getAllErrors());
			modelMap.addAttribute("companyList", accountBiz.selectAllCompany());
			modelMap.addAttribute("roleList", rolePermissionBiz.selectAllRole());
			
			return "/backend/general/accountAdd";
			
		}
		
		accountBiz.insertAccount(dto);
		
		return "redirect:/backend/general/accountController/accountList.do";
		
	}
	
	/** 查找账号 */
	@RequestMapping(value = "/accountList", method = { RequestMethod.POST, RequestMethod.GET })
	public String accountList(HttpServletRequest request, AccountSearchCriteriaDTO criteria, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "accountPermission");
		
		if (criteria.getPagination() == null) {
			criteria.setPagination(new Page());
		}
		
		criteria.getPagination().setTotalCount(accountBiz.getAccountListTotalCountByCriteria(criteria));
		
		modelMap.addAttribute("accountList", accountBiz.selectAccountListByCriteria(criteria));
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		
		return "/backend/general/accountList";
		
	}

	/** 跳转到更新账号页面 */
	@RequestMapping(value = "/accountUpdatePage", method = RequestMethod.GET)
	public String accountUpdatePage(HttpServletRequest request, int id, ModelMap modelMap) {
		
		AccountModifyDTO dto = accountBiz.selectAccountForUpdate(id);
		List<CompanyShowVO> companyList = accountBiz.selectAllCompany();
		List<RoleShowVO> roleList = rolePermissionBiz.selectAllRole();
		
		modelMap.addAttribute("dto", dto);
		modelMap.addAttribute("companyList", companyList);
		modelMap.addAttribute("roleList", roleList);
		
		return "/backend/general/accountUpdate";
		
	}

	/** 更新账号信息 */
	@RequestMapping(value = "/accountUpdate", method = RequestMethod.POST)
	public String accountUpdate(HttpServletRequest request, @Valid AccountModifyDTO dto, BindingResult bindingResult, ModelMap modelMap) {
		
		if (accountBiz.checkAccountDuplication(dto) > 0) {
			
			bindingResult.rejectValue("account", null, "已经存在相同账号与姓名的用户");
			
		}
		
		if (bindingResult.hasErrors()) {
			
			List<CompanyShowVO> companyList = accountBiz.selectAllCompany();
			modelMap.addAttribute("dto", dto);
			modelMap.addAttribute("errors", bindingResult.getAllErrors());
			modelMap.addAttribute("companyList", companyList);
			
			return "/backend/general/accountUpdate";
			
		}
		
		accountBiz.updateAccount(dto);
		
		return "redirect:/backend/general/accountController/accountList.do";
		
	}

	/** 删除账号 */
	@RequestMapping(value = "/accountDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String accountDelete(HttpServletRequest request, int id) {
		
		int success = 0;
		
		AccountSessionVO account = (AccountSessionVO) request.getSession().getAttribute("account");
		
		if (account.getId() != id) {
			
			success = accountBiz.deleteAccount(id);
			
		}
		
		return success + "";
		
	}

	/** 查看详细信息 */
	@RequestMapping(value = "/viewDetail", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String viewDetailByJSON(int id) {
		
		AccountModifyDTO account = accountBiz.selectAccountForUpdate(id);
		
		return JSON.toJSONString(account);
		
	}

}

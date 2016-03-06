package com.easygame.sdk.controller.backend.toner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.toner.TonerModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.toner.TonerSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.toner.TonerShowVO;
import com.easygame.sdk.service.api.backend.toner.ITonerBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/backend/toner/tonerController")
public class TonerController extends BaseController {

	@Autowired
	private ITonerBiz tonerBiz;

	@RequestMapping(value = "/findToner", method = { RequestMethod.GET, RequestMethod.POST })
	public String findToner(TonerSearchCriteriaDTO criteria, HttpServletRequest request, ModelMap modelMap) {

		request.getSession().setAttribute("currentPage", "tonerPermission");

		if (criteria.getPagination() == null) {
			criteria.setPagination(new Page());
		}

		List<TonerShowVO> tonerList = tonerBiz.selectTonerListByCriteria(criteria);
		criteria.getPagination().setTotalCount(tonerBiz.getTonerListTotalCountByCriteria(criteria));

		modelMap.addAttribute("tonerList", tonerList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());

		return "/backend/toner/tonerList";

	}

	@RequestMapping(value = "/tonerAddPage", method = RequestMethod.GET)
	public String tonerAddPage(ModelMap modelMap) {
		return "/backend/toner/tonerAdd";
	}

	@RequestMapping(value = "/tonerAdd", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String tonerAdd(HttpServletRequest request, @Valid TonerModifyDTO toner, BindingResult bindingResult) {

		JSONObject result = new JSONObject();

		if (toner.getName() == null || "".equals(toner.getName())) {

			Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);

			String mess = getApplicationContext().getMessage("backend.admin.list.column.remarks", null, locale);
			bindingResult.rejectValue("name",null, mess);

		}

		if (tonerBiz.checkTonerDuplication(toner.getName(), 0) > 0) {

			bindingResult.rejectValue("name", null, "该名称已经被使用");

		}

		if (bindingResult.hasErrors()) {

			result.put("errors", bindingResult.getAllErrors());

		} else {

			toner = tonerBiz.insertToner(toner);
		}

		result.put("toner", toner);

		return JSON.toJSONString(result);

	}

	@RequestMapping(value = "/tonerUpdatePage", method = { RequestMethod.GET, RequestMethod.POST })
	public String tonerUpdatePage(int id, ModelMap modelMap) {

		TonerModifyDTO toner = tonerBiz.selectTonerForUpdate(id);
		List<TonerShowVO> tonerList = tonerBiz.selectAllToner();

		modelMap.addAttribute("toner", toner);
		modelMap.addAttribute("tonerList", tonerList);

		return "/backend/toner/tonerUpdate";

	}

	@RequestMapping(value = "/tonerUpdate", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String tonerUpdate(@Valid TonerModifyDTO toner, BindingResult bindingResult) {

		JSONObject result = new JSONObject();

		if (tonerBiz.checkTonerDuplication(toner.getName(), toner.getId()) > 0) {

			bindingResult.rejectValue("name", null, "该釉已经存在");

		}

		if (bindingResult.hasErrors()) {

			List<ObjectError> fieldErrors = bindingResult.getAllErrors();
			result.put("errors", fieldErrors);

		} else {

			toner = tonerBiz.updateToner(toner);

		}

		result.put("toner", toner);

		return JSON.toJSONString(result);

	}

	@RequestMapping(value = "/tonerDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String tonerDelete(int id) {

		int success = tonerBiz.deleteToner(id);

		return success + "";

	}

	@RequestMapping(value = "/getTonerById", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getTonerById(Integer id) {

		TonerModifyDTO toner  = tonerBiz.selectTonerForUpdate(id);

		return JSON.toJSONString(toner);

	}
}

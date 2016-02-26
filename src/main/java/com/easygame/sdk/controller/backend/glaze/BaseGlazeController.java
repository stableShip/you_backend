package com.easygame.sdk.controller.backend.glaze;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.glaze.BaseGlazeShowVO;
import com.easygame.sdk.service.api.backend.glaze.IBaseGlazeBiz;
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
@RequestMapping(value = "/backend/glaze/baseGlazeController")
public class BaseGlazeController extends BaseController {

	@Autowired
	private IBaseGlazeBiz baseGlazeBiz;

	@RequestMapping(value = "/findBaseGlaze", method = { RequestMethod.GET, RequestMethod.POST })
	public String findChannel(BaseGlazeSearchCriteriaDTO criteria, HttpServletRequest request, ModelMap modelMap) {

		request.getSession().setAttribute("currentPage", "baseGlazePermission");

		if (criteria.getPagination() == null) {
			criteria.setPagination(new Page());
		}

		List<BaseGlazeShowVO> baseGlazeList = baseGlazeBiz.selectBaseGlazeListByCriteria(criteria);
		criteria.getPagination().setTotalCount(baseGlazeBiz.getBaseGlazeListTotalCountByCriteria(criteria));

		modelMap.addAttribute("baseGlazeList", baseGlazeList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());

		return "/backend/glaze/baseGlazeList";

	}

	@RequestMapping(value = "/baseGlazeAddPage", method = RequestMethod.GET)
	public String baseGlazeAddPage(ModelMap modelMap) {

		List<BaseGlazeShowVO> baseGlazeList = baseGlazeBiz.selectAllBaseGlaze();

		modelMap.addAttribute("baseGlazeList", baseGlazeList);

		return "/backend/glaze/baseGlazeAdd";

	}

	@RequestMapping(value = "/baseGlazeAdd", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String baseGlazeAdd(HttpServletRequest request, @Valid BaseGlazeModifyDTO baseGlaze, BindingResult bindingResult) {

		JSONObject result = new JSONObject();

		if (baseGlaze.getName() == null || "".equals(baseGlaze.getName())) {

			Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);

			String mess = getApplicationContext().getMessage("backend.admin.list.column.remarks", null, locale);
			bindingResult.rejectValue("name",null, mess);

		}

		if (baseGlazeBiz.checkBaseGlazeDuplication(baseGlaze.getName(), 0) > 0) {

			bindingResult.rejectValue("name", null, "渠道已经存在");

		}

		if (bindingResult.hasErrors()) {

			result.put("errors", bindingResult.getAllErrors());

		} else {

			baseGlaze = baseGlazeBiz.insertBaseGlaze(baseGlaze);
		}

		result.put("baseGlaze", baseGlaze);

		return JSON.toJSONString(result);

	}

	@RequestMapping(value = "/baseGlazeUpdatePage", method = { RequestMethod.GET, RequestMethod.POST })
	public String baseGlazeUpdatePage(int id, ModelMap modelMap) {

		BaseGlazeModifyDTO baseGlaze = baseGlazeBiz.selectBaseGlazeForUpdate(id);
		List<BaseGlazeShowVO> baseGlazeList = baseGlazeBiz.selectAllBaseGlaze();

		modelMap.addAttribute("baseGlaze", baseGlaze);
		modelMap.addAttribute("baseGlazeList", baseGlazeList);

		return "/backend/glaze/baseGlazeUpdate";

	}

	@RequestMapping(value = "/baseGlazeUpdate", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String baseGlazeUpdate(@Valid BaseGlazeModifyDTO baseGlaze, BindingResult bindingResult) {

		JSONObject result = new JSONObject();

		if (baseGlazeBiz.checkBaseGlazeDuplication(baseGlaze.getName(), baseGlaze.getId()) > 0) {

			bindingResult.rejectValue("name", null, "渠道已经存在");

		}

		if (bindingResult.hasErrors()) {

			List<ObjectError> fieldErrors = bindingResult.getAllErrors();
			result.put("errors", fieldErrors);

		} else {

			baseGlaze = baseGlazeBiz.updateBaseGlaze(baseGlaze);

		}

		result.put("baseGlaze", baseGlaze);

		return JSON.toJSONString(result);

	}

	@RequestMapping(value = "/baseGlazeDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String baseGlazeDelete(int id) {

		int success = baseGlazeBiz.deleteBaseGlaze(id);

		return success + "";

	}

}

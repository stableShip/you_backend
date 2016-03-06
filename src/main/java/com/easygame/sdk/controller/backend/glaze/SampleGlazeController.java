package com.easygame.sdk.controller.backend.glaze;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.BaseGlazeShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.SampleGlazeShowVO;
import com.easygame.sdk.repository.model.vo.backend.toner.TonerShowVO;
import com.easygame.sdk.service.api.backend.general.IAccountBiz;
import com.easygame.sdk.service.api.backend.glaze.IBaseGlazeBiz;
import com.easygame.sdk.service.api.backend.glaze.ISampleGlazeBiz;
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
@RequestMapping(value = "/backend/glaze/sampleGlazeController")
public class SampleGlazeController extends BaseController {

	@Autowired
	private ISampleGlazeBiz sampleGlazeBiz;

	@Autowired
	private IAccountBiz accountBiz;

	@Autowired
	private IBaseGlazeBiz baseGlazeBiz;

	@Autowired
	private ITonerBiz tonerBiz;

	@RequestMapping(value = "/findSampleGlaze", method = { RequestMethod.GET, RequestMethod.POST })
	public String findSampleGlaze(SampleGlazeSearchCriteriaDTO criteria, HttpServletRequest request, ModelMap modelMap) {

		request.getSession().setAttribute("currentPage", "glazePermission");

		if (criteria.getPagination() == null) {
			criteria.setPagination(new Page());
		}

		List<SampleGlazeShowVO> sampleGlazeList = sampleGlazeBiz.selectSampleGlazeListByCriteria(criteria);
		criteria.getPagination().setTotalCount(sampleGlazeBiz.getSampleGlazeListTotalCountByCriteria(criteria));

		modelMap.addAttribute("sampleGlazeList", sampleGlazeList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());

		return "/backend/glaze/sampleGlazeList";

	}

	@RequestMapping(value = "/sampleGlazeAddPage", method = RequestMethod.GET)
	public String sampleGlazeAddPage(ModelMap modelMap) {
		List<CompanyShowVO>  customerList = accountBiz.selectAllCompany();
		List<BaseGlazeShowVO> baseGlazeList = baseGlazeBiz.selectAllBaseGlaze();
		List<TonerShowVO> tonerList = tonerBiz.selectAllToner();

		modelMap.addAttribute("customerList", customerList);
		modelMap.addAttribute("baseGlazeList", baseGlazeList);
		modelMap.addAttribute("tonerList", tonerList);


		return "/backend/glaze/sampleGlazeAdd";
	}

	@RequestMapping(value = "/sampleGlazeAdd", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String sampleGlazeAdd(HttpServletRequest request, @Valid SampleGlazeModifyDTO sampleGlaze, BindingResult bindingResult) {

		JSONObject result = new JSONObject();

		if (sampleGlaze.getName() == null || "".equals(sampleGlaze.getName())) {

			Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);

			String mess = getApplicationContext().getMessage("backend.admin.list.column.remarks", null, locale);
			bindingResult.rejectValue("name",null, mess);

		}

		if (sampleGlazeBiz.checkSampleGlazeDuplication(sampleGlaze.getName(), 0) > 0) {

			bindingResult.rejectValue("name", null, "该名称已经被使用");

		}

		if (bindingResult.hasErrors()) {

			result.put("errors", bindingResult.getAllErrors());

		} else {

			sampleGlaze = sampleGlazeBiz.insertSampleGlaze(sampleGlaze);
		}

		result.put("sampleGlaze", sampleGlaze);

		return JSON.toJSONString(result);

	}

	@RequestMapping(value = "/sampleGlazeUpdatePage", method = { RequestMethod.GET, RequestMethod.POST })
	public String sampleGlazeUpdatePage(int id, ModelMap modelMap) {

		SampleGlazeModifyDTO sampleGlaze = sampleGlazeBiz.selectSampleGlazeForUpdate(id);
		List<SampleGlazeShowVO> sampleGlazeList = sampleGlazeBiz.selectAllSampleGlaze();

		modelMap.addAttribute("sampleGlaze", sampleGlaze);
		modelMap.addAttribute("sampleGlazeList", sampleGlazeList);

		return "/backend/glaze/sampleGlazeUpdate";

	}

	@RequestMapping(value = "/sampleGlazeUpdate", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String sampleGlazeUpdate(@Valid SampleGlazeModifyDTO sampleGlaze, BindingResult bindingResult) {

		JSONObject result = new JSONObject();

		if (sampleGlazeBiz.checkSampleGlazeDuplication(sampleGlaze.getName(), sampleGlaze.getId()) > 0) {

			bindingResult.rejectValue("name", null, "该釉已经存在");

		}

		if (bindingResult.hasErrors()) {

			List<ObjectError> fieldErrors = bindingResult.getAllErrors();
			result.put("errors", fieldErrors);

		} else {

			sampleGlaze = sampleGlazeBiz.updateSampleGlaze(sampleGlaze);

		}

		result.put("sampleGlaze", sampleGlaze);

		return JSON.toJSONString(result);

	}

	@RequestMapping(value = "/sampleGlazeDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String sampleGlazeDelete(int id) {

		int success = sampleGlazeBiz.deleteSampleGlaze(id);

		return success + "";

	}

}

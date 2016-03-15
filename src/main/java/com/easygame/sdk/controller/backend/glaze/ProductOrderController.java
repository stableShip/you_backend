package com.easygame.sdk.controller.backend.glaze;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.common.util.TimeUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.glaze.ProductOrderModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.ProductOrderSearchCriteriaDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeModifyDTO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.BaseGlazeShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.ProductOrderShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.SampleGlazeShowVO;
import com.easygame.sdk.repository.model.vo.backend.toner.TonerShowVO;
import com.easygame.sdk.service.api.backend.general.IAccountBiz;
import com.easygame.sdk.service.api.backend.glaze.IBaseGlazeBiz;
import com.easygame.sdk.service.api.backend.glaze.IProductOrderBiz;
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
@RequestMapping(value = "/backend/glaze/productOrderController")
public class ProductOrderController extends BaseController {

	@Autowired
	private ISampleGlazeBiz sampleGlazeBiz;

	@Autowired
	private IProductOrderBiz productOrderBiz;

	@Autowired
	private IAccountBiz accountBiz;

	@Autowired
	private IBaseGlazeBiz baseGlazeBiz;

	@Autowired
	private ITonerBiz tonerBiz;

	@RequestMapping(value = "/findProductOrder", method = { RequestMethod.GET, RequestMethod.POST })
	public String findProductOrder(ProductOrderSearchCriteriaDTO criteria, HttpServletRequest request, ModelMap modelMap) {

		request.getSession().setAttribute("currentPage", "productOrderPermission");

		if (criteria.getPagination() == null) {
			criteria.setPagination(new Page());
		}

		if (criteria.getSearchStartDay() == null) {

			criteria.setSearchStartDay(TimeUtils.getFirstDayOfThisMonth());
			criteria.setSearchEndDay(TimeUtils.getNowDate("yyyy-MM-dd"));

		}
		List<ProductOrderShowVO> productOrderList = productOrderBiz.selectProductOrderListByCriteria(criteria);
		criteria.getPagination().setTotalCount(productOrderBiz.getProductOrderListTotalCountByCriteria(criteria));

		modelMap.addAttribute("productOrderList", productOrderList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());

		return "/backend/glaze/productOrderList";

	}

	@RequestMapping(value = "/productOrderAddPage", method = RequestMethod.GET)
	public String productOrderAddPage(HttpServletRequest request, Integer sampleGlazeId, ModelMap modelMap) {
		List<CompanyShowVO> customerList = productOrderBiz.getCustomerOptions();
		if(sampleGlazeId != null) {
			SampleGlazeModifyDTO sampleGlaze =  sampleGlazeBiz.selectSampleGlazeForUpdate(sampleGlazeId);
			Integer customerId = sampleGlaze.getCustomer().getId();
			modelMap.addAttribute("customerId", customerId);
			modelMap.addAttribute("sampleGlaze", sampleGlaze);
		}
		modelMap.addAttribute("customerList", customerList);
		return "/backend/glaze/productOrderAdd";
	}

	/** 获取样品釉下拉选择 */
	@RequestMapping(value = "/getSampleGlazeOptions", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getSampleGlazeOptions(HttpServletRequest request, Integer customerId) {

		return JSON.toJSONString(productOrderBiz.getSampleGlazeOptions(customerId));

	}

	@RequestMapping(value = "/getTonerAndBaseGlaze", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getTonerAndBaseGlaze(HttpServletRequest request, Integer sampleGlazeId) {
		SampleGlazeModifyDTO sampleGlaze = sampleGlazeBiz.selectSampleGlazeForUpdate(sampleGlazeId);
		return JSON.toJSONString(sampleGlaze);

	}

	@RequestMapping(value = "/productOrderAdd", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String productOrderAdd(HttpServletRequest request, @Valid ProductOrderModifyDTO productOrder, BindingResult bindingResult) {

		JSONObject result = new JSONObject();

		if (bindingResult.hasErrors()) {

			result.put("errors", bindingResult.getAllErrors());

		} else {

			productOrder = productOrderBiz.insertProductOrder(productOrder);
		}

		result.put("productOrder", productOrder);

		return JSON.toJSONString(result);

	}

	@RequestMapping(value = "/productOrderUpdatePage", method = { RequestMethod.GET, RequestMethod.POST })
	public String productOrderUpdatePage(int id, ModelMap modelMap) {

		ProductOrderModifyDTO productOrder = productOrderBiz.selectProductOrderForUpdate(id);

		List<CompanyShowVO>  customerList = accountBiz.selectAllCompany();
		List<BaseGlazeShowVO> baseGlazeList = baseGlazeBiz.selectAllBaseGlaze();
		List<TonerShowVO> tonerList = tonerBiz.selectAllToner();

		modelMap.addAttribute("customerList", customerList);
		modelMap.addAttribute("baseGlazeList", baseGlazeList);
		modelMap.addAttribute("tonerList", tonerList);
		modelMap.addAttribute("productOrder", productOrder);

		return "/backend/glaze/productOrderUpdate";

	}

	@RequestMapping(value = "/productOrderUpdate", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String productOrderUpdate(@Valid ProductOrderModifyDTO productOrder, BindingResult bindingResult) {

		JSONObject result = new JSONObject();

		if (bindingResult.hasErrors()) {

			List<ObjectError> fieldErrors = bindingResult.getAllErrors();
			result.put("errors", fieldErrors);

		} else {

			productOrder = productOrderBiz.updateProductOrder(productOrder);

		}

		result.put("productOrder", productOrder);

		return JSON.toJSONString(result);

	}

	@RequestMapping(value = "/productOrderDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String productOrderDelete(int id) {

		int success = productOrderBiz.deleteProductOrder(id);

		return success + "";

	}

	/** 查看详细信息 */
	@RequestMapping(value = "/viewDetail", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String viewDetail(int id) {
		ProductOrderModifyDTO productOrder = productOrderBiz.selectProductOrderForUpdate(id);
		JSONObject result = new JSONObject();
		result.put("productOrder", productOrder);
		return JSON.toJSONString(result);
	}

}

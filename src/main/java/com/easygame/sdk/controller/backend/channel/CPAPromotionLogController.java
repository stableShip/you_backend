package com.easygame.sdk.controller.backend.channel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.common.util.TimeUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionLogSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionLogShowVO;
import com.easygame.sdk.service.api.backend.channel.ICPAPromotionLogBiz;

@Controller
@RequestMapping(value = "/backend/channel/cpaPromotionLogController")
public class CPAPromotionLogController extends BaseController {

	@Autowired
	private ICPAPromotionLogBiz cpaPromotionLogBiz;

	@RequestMapping(value = "/cpaPromotionLogList", method = { RequestMethod.POST, RequestMethod.GET })
	public String findPromotion(CPAPromotionLogSearchCriteriaDTO criteria, HttpServletRequest request, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "cpaPromotionLogPermission");
		
		if (criteria.getPagination() == null) {
			
			criteria.setPagination(new Page());
			
		}
		
		if(criteria.getSearchStartTime() == null){
			
			criteria.setSearchStartTime(TimeUtils.getNowDate("yyyy-MM-dd"));
			criteria.setSearchEndTime(TimeUtils.getNowDate("yyyy-MM-dd"));
			
		}
		
		List<CPAPromotionLogShowVO> promotionLogList = cpaPromotionLogBiz.selectPromotionLogsByCriteria(criteria);
		criteria.getPagination().setTotalCount(cpaPromotionLogBiz.getPromotionLogsListTotalCountByCriteria(criteria));
		
		modelMap.addAttribute("promotionLogList", promotionLogList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		
		return "/backend/channel/cpaPromotionLogList";
		
	}

}

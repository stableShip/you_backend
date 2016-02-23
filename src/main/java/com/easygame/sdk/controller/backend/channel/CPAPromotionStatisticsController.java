package com.easygame.sdk.controller.backend.channel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easygame.sdk.common.report.ReportPdfExporter;
import com.easygame.sdk.common.report.ReportView;
import com.easygame.sdk.common.report.ReportXlsExporter;
import com.easygame.sdk.common.util.MemcachedUtils;
import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.common.util.TimeUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionStatisticsSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionStatisticsShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountSessionVO;
import com.easygame.sdk.service.api.backend.channel.ICPAPromotionStatisticsBiz;

@Controller
@RequestMapping(value = "/backend/channel/cpaPromotionStatisticsController")
public class CPAPromotionStatisticsController extends BaseController{

	@Autowired
	private ICPAPromotionStatisticsBiz cpaPromotionStatisticsBiz;

	@Autowired
	private ReportView reportView;

	@Autowired
	private ReportPdfExporter reportPdfExporter;

	@Autowired
	private ReportXlsExporter reportXlsExporter;
	
	@Autowired
	private MemcachedUtils memcachedUtils;

	@RequestMapping(value = "/cpaPromotionStatisticsList", method = { RequestMethod.POST, RequestMethod.GET })
	public String cpaPromotionStatisticsList( CPAPromotionStatisticsSearchCriteriaDTO criteria, HttpServletRequest request, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "cpaPromotionStatisticsPermission");
		
		if (criteria.getPagination() == null) {
			
			criteria.setPagination(new Page());
			
		}
		
		if (criteria.getSearchStartDay() == null) {
			
			criteria.setSearchStartDay(TimeUtils.getFirstDayOfThisMonth());
			criteria.setSearchEndDay(TimeUtils.getNowDate("yyyy-MM-dd"));
			
		}
		
		AccountSessionVO account = (AccountSessionVO) request.getSession().getAttribute("account");
		criteria.setInternal(account.isInternal());
		criteria.setUserId(account.getId());
		
		List<CPAPromotionStatisticsShowVO> promotionStatisticsList = cpaPromotionStatisticsBiz.selectPromotionStatisticsListByCriteria(criteria);
		criteria.getPagination().setTotalCount(cpaPromotionStatisticsBiz.getPromotionStatisticsListTotalCountByCriteria(criteria));
		
		modelMap.addAttribute("promotionStatisticsList", promotionStatisticsList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		
		return "/backend/channel/cpaPromotionStatisticsList";
		
	}

	@RequestMapping(value = "/showReport", method = { RequestMethod.POST, RequestMethod.GET })
	public String createPromotionStatisticsExcel( CPAPromotionStatisticsSearchCriteriaDTO criteria, HttpServletRequest request, HttpServletResponse response) {
//		Map params = new HashMap();
//		params.put(PromotionStatisticsShowVO.APPNAME,
//				criteria.getSearchAppName());
//		params.put(PromotionStatisticsShowVO.APPNICKNAME,
//				criteria.getSearchAppNickName());
//		String type = "";
//		if (criteria.getSearchType() == 0) {
//			type = "CPS";
//		} else if (criteria.getSearchType() == 1) {
//			type = "CPA";
//		} else if (criteria.getSearchType() == 2) {
//			type = "CPT";
//		} else {
//			type = "全部";
//		}
//		params.put(PromotionStatisticsShowVO.TYPE, type);
//		List<PromotionStatisticsShowVO> promotionStatisticsList = null;
//		if (criteria.getSearchDataType() == 0) {
//			params.put(PromotionStatisticsShowVO.BEGINTIME,
//					criteria.getSearchStartDay());
//			params.put(PromotionStatisticsShowVO.ENDTIME,
//					criteria.getSearchEndDay());
//		} else if (criteria.getSearchDataType() == 1) {
//			params.put(PromotionStatisticsShowVO.BEGINTIME,
//					criteria.getSearchStartMonth());
//			params.put(PromotionStatisticsShowVO.ENDTIME,
//					criteria.getSearchEndMonth());
//		}
//		AdminSessionVO admin = (AdminSessionVO) request.getSession()
//				.getAttribute("administrator");
//		criteria.setInternal(admin.isInternal());
//		promotionStatisticsList = promotionStatisticsBiz
//				.selectPromotionStatisticsListByCriteria(criteria);
//		reportView.setReportTemplateName("promotionStatisticsReport");
//		reportView.setDataList(promotionStatisticsList);
//		reportView.setFileType(".xls");
//		reportView.setReportFileExporter(reportXlsExporter);
//		return new ModelAndView(reportView, params);
		
		return null;
		
	}
}

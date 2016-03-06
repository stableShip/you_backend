package com.easygame.sdk.service.impl.backend.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.channel.CPAPromotionStatisticsMapper;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionStatisticsSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionStatisticsShowVO;
import com.easygame.sdk.service.api.backend.channel.ICPAPromotionStatisticsBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "promotionStatisticsBiz")
public class CPAPromotionStatisticsBizImpl extends BaseBizImpl implements ICPAPromotionStatisticsBiz {

	@Autowired
	private CPAPromotionStatisticsMapper promotionStatisticsMapper;

	public List<CPAPromotionStatisticsShowVO> selectPromotionStatisticsListByCriteria(CPAPromotionStatisticsSearchCriteriaDTO criteria) {
		
		return promotionStatisticsMapper.selectPromotionStatisticsCPAListByCriteria(criteria);
		
	}

	public int getPromotionStatisticsListTotalCountByCriteria(CPAPromotionStatisticsSearchCriteriaDTO criteria) {
		
		return promotionStatisticsMapper.getPromotionStatisticsCPAListTotalCountByCriteria(criteria);
		
	}

}

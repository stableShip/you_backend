package com.easygame.sdk.repository.mapper.backend.channel;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionStatisticsSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionStatisticsShowVO;

public interface CPAPromotionStatisticsMapper {

	List<CPAPromotionStatisticsShowVO> selectPromotionStatisticsCPAListByCriteria(CPAPromotionStatisticsSearchCriteriaDTO criteria);
	
	int getPromotionStatisticsCPAListTotalCountByCriteria(CPAPromotionStatisticsSearchCriteriaDTO criteria);

}

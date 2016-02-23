package com.easygame.sdk.service.api.backend.channel;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionStatisticsSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionStatisticsShowVO;

public interface ICPAPromotionStatisticsBiz {

	public List<CPAPromotionStatisticsShowVO> selectPromotionStatisticsListByCriteria(
			CPAPromotionStatisticsSearchCriteriaDTO criteria);

	public int getPromotionStatisticsListTotalCountByCriteria(
			CPAPromotionStatisticsSearchCriteriaDTO criteria);

}

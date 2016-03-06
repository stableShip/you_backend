package com.easygame.sdk.service.api.backend.channel;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionLogSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionLogShowVO;

public interface ICPAPromotionLogBiz {

	public List<CPAPromotionLogShowVO> selectPromotionLogsByCriteria(
			CPAPromotionLogSearchCriteriaDTO criteria);

	public int getPromotionLogsListTotalCountByCriteria(
			CPAPromotionLogSearchCriteriaDTO criteria);

}

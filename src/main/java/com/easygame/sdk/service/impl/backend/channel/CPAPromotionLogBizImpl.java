package com.easygame.sdk.service.impl.backend.channel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.channel.CPAPromotionLogMapper;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionLogSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionLogShowVO;
import com.easygame.sdk.service.api.backend.channel.ICPAPromotionLogBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "promotionLogBiz")
public class CPAPromotionLogBizImpl extends BaseBizImpl implements
		ICPAPromotionLogBiz {

	@Autowired
	private CPAPromotionLogMapper promotionLogMapper;

	public List<CPAPromotionLogShowVO> selectPromotionLogsByCriteria(
			CPAPromotionLogSearchCriteriaDTO criteria) {
		return promotionLogMapper.selectPromotionLogsByCriteria(criteria);
	}

	public int getPromotionLogsListTotalCountByCriteria(
			CPAPromotionLogSearchCriteriaDTO criteria) {
		return promotionLogMapper
				.getPromotionLogsListTotalCountByCriteria(criteria);
	}

}

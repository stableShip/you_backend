package com.easygame.sdk.repository.mapper.backend.channel;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionLogSearchCriteriaDTO;
import com.easygame.sdk.repository.model.po.CPAPromotionLog;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionLogShowVO;

public interface CPAPromotionLogMapper {
	
	int insertPromotionLog(CPAPromotionLog record);
	
	List<CPAPromotionLogShowVO> selectPromotionLogsByCriteria(CPAPromotionLogSearchCriteriaDTO criteria);
	
	int getPromotionLogsListTotalCountByCriteria(CPAPromotionLogSearchCriteriaDTO criteria);
   
}
package com.easygame.sdk.service.api.backend.ad;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.ad.ScreenAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.ScreenAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.ScreenAdShowVO;

public interface IScreenAdBiz {
	
	List<ScreenAdShowVO> selectScreenAdListByCriteria(ScreenAdSearchCriteriaDTO criteria);
	
	
	/** 插入Banner */
	public ScreenAdShowVO insertScreenAd(ScreenAdModifyDTO record);
	

	int deleteScreenAd(int id);

	
	ScreenAdShowVO selectScreenAdForUpdate(int id);


	int updateScreenAd(ScreenAdModifyDTO bannerAd);


	int getScreenAdListTotalCountByCriteria(ScreenAdSearchCriteriaDTO criteria);


	int checkScreenAdDuplication(String name, int id);
}

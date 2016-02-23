package com.easygame.sdk.service.api.backend.ad;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.ad.GamecenterAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.GamecenterAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.GamecenterAdShowVO;

public interface IGamecenterAdBiz {
	
	List<GamecenterAdShowVO> selectGamecenterAdListByCriteria(GamecenterAdSearchCriteriaDTO criteria);
	
	
	/** 插入Banner */
	public GamecenterAdShowVO insertGamecenterAd(GamecenterAdModifyDTO record);
	
	
	
	int deleteGamecenterAd(int id);

	
	GamecenterAdShowVO selectGamecenterAdForUpdate(int id);


	int updateGamecenterAd(GamecenterAdModifyDTO bannerAd);


	int getGamecenterAdListTotalCountByCriteria(GamecenterAdSearchCriteriaDTO criteria);


	int checkGamecenterAdDuplication(String name, int id);


	int updateShowIndex(GamecenterAdModifyDTO gamecenterAd);
	
	/*int updateShowIndex(int showIndex,int originalIndex,int id);*/
}

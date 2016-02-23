package com.easygame.sdk.service.api.backend.ad;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.ad.BannerAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.BannerAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.BannerAdShowVO;

public interface IBannerAdBiz {
	
	List<BannerAdShowVO> selectBannerAdListByCriteria(BannerAdSearchCriteriaDTO criteria);
	
	
	/** 插入Banner */
	public BannerAdShowVO insertBannerAd(BannerAdModifyDTO record);
	

	int deleteBannerAd(int id);

	
	BannerAdShowVO selectBannerAdForUpdate(int id);


	int updateBannerAd(BannerAdModifyDTO bannerAd);


	int getBannerAdListTotalCountByCriteria(BannerAdSearchCriteriaDTO criteria);


	int checkBannerAdDuplication(String name, int id);
}

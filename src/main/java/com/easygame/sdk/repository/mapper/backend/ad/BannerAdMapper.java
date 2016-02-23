package com.easygame.sdk.repository.mapper.backend.ad;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.ad.BannerAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.BannerAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.po.BannerAd;
import com.easygame.sdk.repository.model.vo.backend.ad.BannerAdShowVO;

public interface BannerAdMapper {
	
	List<BannerAdShowVO> selectBannerAdListByCriteria(BannerAdSearchCriteriaDTO criteria);
	
	int insertBannerAd(BannerAd record);

	int updateBannerAd(BannerAd record);
    	
	BannerAdShowVO selectBannerAdByPrimaryKey(Integer id);
    
    /** 检测广告是否重复 */
	int checkIfBannerAdExist(@Param("bannerAdName") String BannerAdName, @Param("id") Integer id);
    
	int deleteBannerAdByPrimaryKey(Integer id);

	int getBannerAdListTotalCountByCriteria(BannerAdSearchCriteriaDTO criteria);

	int checkBannerAdDeleteSecurity(int id);
    
   
}
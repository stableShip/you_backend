package com.easygame.sdk.repository.mapper.backend.ad;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.ad.search.ScreenAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.po.ScreenAd;
import com.easygame.sdk.repository.model.vo.backend.ad.ScreenAdShowVO;

public interface ScreenAdMapper {
	
	List<ScreenAdShowVO> selectScreenAdListByCriteria(ScreenAdSearchCriteriaDTO criteria);
	
	int insertScreenAd(ScreenAd record);

	int updateScreenAd(ScreenAd record);
    	
	ScreenAdShowVO selectScreenAdByPrimaryKey(Integer id);
    
    /** 检测广告是否重复 */
	int checkIfScreenAdExist(@Param("screenAdName") String ScreenAdName, @Param("id") Integer id);
    
	int deleteScreenAdByPrimaryKey(Integer id);

	int getScreenAdListTotalCountByCriteria(ScreenAdSearchCriteriaDTO criteria);

	int checkScreenAdDeleteSecurity(int id);
    
   
}
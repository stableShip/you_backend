package com.easygame.sdk.repository.mapper.backend.ad;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.ad.GamecenterAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.GamecenterAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.po.GamecenterAd;
import com.easygame.sdk.repository.model.vo.backend.ad.GamecenterAdShowVO;

public interface GamecenterAdMapper {
	
	List<GamecenterAdShowVO> selectGamecenterAdListByCriteria(GamecenterAdSearchCriteriaDTO criteria);
	
	int insertGamecenterAd(GamecenterAd record);

	int updateGamecenterAd(GamecenterAd record);
    	
	GamecenterAdShowVO selectGamecenterAdByPrimaryKey(Integer id);
    
	/** 检测广告是否重复 */
	int checkIfGamecenterAdExist(@Param("gamecenterAdName") String GamecenterAdName, @Param("id") Integer id);
    
	int deleteGamecenterAdByPrimaryKey(Integer id);

	int getGamecenterAdListTotalCountByCriteria(GamecenterAdSearchCriteriaDTO criteria);

	int checkGamecenterAdDeleteSecurity(int id);
		
	int updateShowIndex(GamecenterAdModifyDTO gamecenterAd);
	
	/** 修改一段区间的showIndex，功能：使其在修改其中一项数据的showIndex后，其他数据的showIndex能够自动变化*/
	int updateAllShowIndex(@Param("move") Boolean move,@Param("originalShowIndex") Integer originalShowIndex,@Param("showIndex") Integer showIndex);

	int selectGamecenterAdMaxShowIndex();
	
	int checkIfShowIndexExist(@Param("showIndex")int showIndex);
}
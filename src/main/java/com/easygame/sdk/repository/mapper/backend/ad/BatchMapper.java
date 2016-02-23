package com.easygame.sdk.repository.mapper.backend.ad;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.vo.backend.ad.selection.AppVO;
import com.easygame.sdk.repository.model.vo.backend.ad.selection.ChannelVO;
import com.easygame.sdk.repository.model.vo.backend.ad.selection.CpaAppVO;

public interface BatchMapper {
	
	List<ChannelVO> getCpaChannelList();
	
	List<AppVO> getAppList(Integer channelId);

	List<CpaAppVO> getCpaAppList(@Param(value="channelId")Integer channelId, @Param(value="appId")Integer appId);
	
	CpaAppVO getCpaPromotion(@Param(value="cpaId")Integer cpaId);
	
}

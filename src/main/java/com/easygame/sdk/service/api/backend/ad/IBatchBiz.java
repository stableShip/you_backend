package com.easygame.sdk.service.api.backend.ad;

import java.util.List;

import com.easygame.sdk.repository.model.vo.backend.ad.selection.AppVO;
import com.easygame.sdk.repository.model.vo.backend.ad.selection.ChannelVO;
import com.easygame.sdk.repository.model.vo.backend.ad.selection.CpaAppVO;

public interface IBatchBiz {
	
	public List<ChannelVO> getChannelList();
	
	public List<AppVO> getAppList(Integer channelId);
	
	public List<CpaAppVO> getCpaAppList(Integer channelId, Integer appId);
	
	public CpaAppVO getCpaPromotionVO(Integer cpaId);

}

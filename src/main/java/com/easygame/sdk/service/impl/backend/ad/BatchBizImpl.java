package com.easygame.sdk.service.impl.backend.ad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.ad.BatchMapper;
import com.easygame.sdk.repository.model.vo.backend.ad.selection.AppVO;
import com.easygame.sdk.repository.model.vo.backend.ad.selection.ChannelVO;
import com.easygame.sdk.repository.model.vo.backend.ad.selection.CpaAppVO;
import com.easygame.sdk.service.api.backend.ad.IBatchBiz;

@Service(value = "batchBiz")
public class BatchBizImpl implements IBatchBiz {
	
	@Autowired
	private BatchMapper batchMapper;

	public List<ChannelVO> getChannelList() {
		return batchMapper.getCpaChannelList();
	}

	public List<AppVO> getAppList(Integer channelId) {
		return batchMapper.getAppList(channelId);
	}

	public List<CpaAppVO> getCpaAppList(Integer channelId, Integer appId) {
		return batchMapper.getCpaAppList(channelId, appId);
	}

	public CpaAppVO getCpaPromotionVO(Integer cpaId) {
		
		return batchMapper.getCpaPromotion(cpaId);
		
	}

}
package com.easygame.sdk.service.api.webservices;

import java.util.List;

import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.GamecenterAdResultVO;

public interface IGamecenterAdServiceBiz {
	
	public List<GamecenterAdResultVO> getGamecenterAdList(AdParamsDTO param, String ip);
	
	public int insertGamecenterAdClickRecord(AdParamsDTO param, String ip);
	
	public int insertGamecenterAdDownloadRecord(AdParamsDTO param, String ip);

}

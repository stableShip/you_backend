package com.easygame.sdk.service.api.webservices;

import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.ScreenAdResultVO;

public interface IScreenAdServiceBiz {
	
	public ScreenAdResultVO getScreenAdInformation(AdParamsDTO param, String ip);
	
	public int insertScreenAdClickRecord(AdParamsDTO param, String ip);
	
	public int insertScreenAdDownloadRecord(AdParamsDTO param, String ip);

}

package com.easygame.sdk.service.api.webservices;

import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.BannerAdResultVO;

public interface IBannerAdServiceBiz {
	
	public BannerAdResultVO getBannerAdInformation(AdParamsDTO param, String ip);
	
	public int insertBannerAdClickRecord(AdParamsDTO param, String ip);
	
	public int insertBannerAdDownloadRecord(AdParamsDTO param, String ip);

}

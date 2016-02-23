package com.easygame.sdk.service.impl.webservices;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.webservices.BannerAdServiceMapper;
import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.BannerAdResultVO;
import com.easygame.sdk.service.api.webservices.IBannerAdServiceBiz;

@Service(value = "bannerAdServiceBiz")
public class BannerAdServiceBizImpl implements IBannerAdServiceBiz {
	
	@Autowired
	private BannerAdServiceMapper bannerAdServiceMapper;

	public BannerAdResultVO getBannerAdInformation(AdParamsDTO param, String ip) {
		
		BannerAdResultVO result = bannerAdServiceMapper.getBannerAdInformation(param);
//		bannerAdServiceMapper.insertBannerAdDisplayRecord(param, ip, new Date());
		
		return result;
	}

	public int insertBannerAdClickRecord(AdParamsDTO param, String ip) {
		
		return bannerAdServiceMapper.insertBannerAdClickRecord(param, ip, new Date());
		
	}

	public int insertBannerAdDownloadRecord(AdParamsDTO param, String ip) {
		
		return bannerAdServiceMapper.insertBannerAdDownloadRecord(param, ip, new Date());
		
	}

}

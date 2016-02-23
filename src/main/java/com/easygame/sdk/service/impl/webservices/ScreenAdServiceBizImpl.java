package com.easygame.sdk.service.impl.webservices;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.webservices.ScreenAdServiceMapper;
import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.ScreenAdResultVO;
import com.easygame.sdk.service.api.webservices.IScreenAdServiceBiz;

@Service(value = "screenAdServiceBiz")
public class ScreenAdServiceBizImpl implements IScreenAdServiceBiz {
	
	@Autowired
	private ScreenAdServiceMapper screenAdServiceMapper;

	public ScreenAdResultVO getScreenAdInformation(AdParamsDTO param, String ip) {
		
		ScreenAdResultVO result = screenAdServiceMapper.getScreenAdInformation(param);
		param.setAdId(result.getId());
		screenAdServiceMapper.insertScreenAdDisplayRecord(param, ip, new Date());
		
		return result;
		
	}

	public int insertScreenAdClickRecord(AdParamsDTO param, String ip) {
		
		return screenAdServiceMapper.insertScreenAdClickRecord(param, ip, new Date());
		
	}

	public int insertScreenAdDownloadRecord(AdParamsDTO param, String ip) {
		
		return screenAdServiceMapper.insertScreenAdDownloadRecord(param, ip, new Date());
		
	}

}

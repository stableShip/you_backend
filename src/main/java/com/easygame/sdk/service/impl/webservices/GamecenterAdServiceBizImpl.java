package com.easygame.sdk.service.impl.webservices;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.webservices.GamecenterAdServiceMapper;
import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.GamecenterAdResultVO;
import com.easygame.sdk.service.api.webservices.IGamecenterAdServiceBiz;

@Service(value = "gamecenterAdServiceBiz")
public class GamecenterAdServiceBizImpl implements IGamecenterAdServiceBiz {
	
	@Autowired
	private GamecenterAdServiceMapper gamecenterAdServiceMapper;

	public List<GamecenterAdResultVO> getGamecenterAdList(AdParamsDTO param, String ip) {
		
		return gamecenterAdServiceMapper.getGamecenterAdList();
		
	}

	public int insertGamecenterAdClickRecord(AdParamsDTO param, String ip) {
		
		return gamecenterAdServiceMapper.insertGamecenterAdClickRecord(param, ip, new Date());
		
	}

	public int insertGamecenterAdDownloadRecord(AdParamsDTO param, String ip) {
		
		return gamecenterAdServiceMapper.insertGamecenterAdDownloadRecord(param, ip, new Date());
		
	}

}

package com.easygame.sdk.service.impl.webservices;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.webservices.NotificationAdServiceMapper;
import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.NotificationAdResultVO;
import com.easygame.sdk.service.api.webservices.INotificationAdServiceBiz;

@Service(value = "notificationAdServiceBiz")
public class NotificationAdServiceBizImpl implements INotificationAdServiceBiz {
	
	@Autowired
	private NotificationAdServiceMapper notificationAdServiceMapper;

	public NotificationAdResultVO getNotificationAdInformation(AdParamsDTO param, String ip) {
		
		NotificationAdResultVO result = notificationAdServiceMapper.getNotificationAdInformation(param);
		param.setAdId(result.getId());
		notificationAdServiceMapper.insertNotificationAdDisplayRecord(param, ip, new Date());
		
		return result;
		
	}

	public int insertNotificationAdClickRecord(AdParamsDTO param, String ip) {
		
		return notificationAdServiceMapper.insertNotificationAdClickRecord(param, ip, new Date());
		
	}

	public int insertNotificationAdDownloadRecord(AdParamsDTO param, String ip) {
		
		return notificationAdServiceMapper.insertNotificationAdClickRecord(param, ip, new Date());
		
	}

}

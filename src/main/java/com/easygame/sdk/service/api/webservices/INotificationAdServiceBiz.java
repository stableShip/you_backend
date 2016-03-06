package com.easygame.sdk.service.api.webservices;

import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.NotificationAdResultVO;

public interface INotificationAdServiceBiz {
	
	public NotificationAdResultVO getNotificationAdInformation(AdParamsDTO param, String ip);
	
	public int insertNotificationAdClickRecord(AdParamsDTO param,String ip);
	
	public int insertNotificationAdDownloadRecord(AdParamsDTO param,String ip);

}

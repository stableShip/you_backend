package com.easygame.sdk.service.api.backend.market;

import com.easygame.sdk.repository.model.dto.backend.market.AppNotificationModifyDTO;
import com.easygame.sdk.repository.model.dto.webservices.NotificationAppInformationResultDTO;

public interface IAppNotificationBiz {
	
	AppNotificationModifyDTO selectAppNotificationForUpdate(int appId);
	
	int insertAppNotification(AppNotificationModifyDTO record);
	
	int updateAppNotification(AppNotificationModifyDTO record);
	
	NotificationAppInformationResultDTO getNotificationAppInformation();
	
	int updateAppNotificationSelected(int appId);

}
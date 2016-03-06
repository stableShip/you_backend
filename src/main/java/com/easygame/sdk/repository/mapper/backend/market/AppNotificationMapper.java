package com.easygame.sdk.repository.mapper.backend.market;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.market.AppNotificationModifyDTO;
import com.easygame.sdk.repository.model.dto.webservices.NotificationAppInformationResultDTO;
import com.easygame.sdk.repository.model.po.AppNotification;

public interface AppNotificationMapper {

	AppNotificationModifyDTO selectAppNotificationByPrimaryKey(Integer id);
	
    int insertAppNotification(AppNotification record);

    int updateAppNotification(AppNotification record);
    
    NotificationAppInformationResultDTO getNotificationAppInformation();
    
    int updateAppNotificationSelected(@Param(value="appId") int appId);
    
}
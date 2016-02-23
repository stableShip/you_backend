package com.easygame.sdk.service.impl.backend.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.market.AppNotificationMapper;
import com.easygame.sdk.repository.model.dto.backend.market.AppNotificationModifyDTO;
import com.easygame.sdk.repository.model.dto.webservices.NotificationAppInformationResultDTO;
import com.easygame.sdk.repository.model.po.AppNotification;
import com.easygame.sdk.service.api.backend.market.IAppNotificationBiz;

@Service(value = "appNotificationBiz")
public class AppNotificationBizImpl implements IAppNotificationBiz {
	
	@Autowired
	private AppNotificationMapper appNotificationMapper;

	public AppNotificationModifyDTO selectAppNotificationForUpdate(int appId) {
		return appNotificationMapper.selectAppNotificationByPrimaryKey(appId);
	}

	public int insertAppNotification(AppNotificationModifyDTO record) {
		AppNotification appNotification = new AppNotification();
		appNotification.setAppId(record.getAppId());
		appNotification.setIconUrl(record.getIconUrl());
		appNotification.setPackageName(record.getPackageName());
		appNotification.setPromotionWord(record.getPromotionWord());
		appNotification.setDownloadUrl(record.getDownloadUrl());
		return appNotificationMapper.insertAppNotification(appNotification);
	}

	public int updateAppNotification(AppNotificationModifyDTO record) {
		AppNotification appNotification = new AppNotification();
		appNotification.setId(record.getAppNotificationId());
		appNotification.setAppId(record.getAppId());
		appNotification.setIconUrl(record.getIconUrl());
		appNotification.setPackageName(record.getPackageName());
		appNotification.setPromotionWord(record.getPromotionWord());
		appNotification.setDownloadUrl(record.getDownloadUrl());
		return appNotificationMapper.updateAppNotification(appNotification);
	}

	public NotificationAppInformationResultDTO getNotificationAppInformation() {
		return appNotificationMapper.getNotificationAppInformation();
	}

	public int updateAppNotificationSelected(int appId) {
		return appNotificationMapper.updateAppNotificationSelected(appId);
	}

}
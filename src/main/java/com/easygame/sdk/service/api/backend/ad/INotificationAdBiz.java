package com.easygame.sdk.service.api.backend.ad;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.ad.NotificationAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.NotificationAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.BannerAdShowVO;
import com.easygame.sdk.repository.model.vo.backend.ad.NotificationAdShowVO;

public interface INotificationAdBiz {

	List<NotificationAdShowVO> selectNotificationAdListByCriteria(NotificationAdSearchCriteriaDTO criteria);
	
	int insertNotificationAd(NotificationAdModifyDTO record);

	int getNotificationAdListTotalCountByCriteria(NotificationAdSearchCriteriaDTO criteria);

	int deleteNotificationAd(int id);
	
	NotificationAdShowVO selectNotificationAdAdForUpdate(int id);
	
	int updateNotificationAd(NotificationAdModifyDTO notificationAd);

	int checkNotificationAdDuplication(String name, Integer id);
}
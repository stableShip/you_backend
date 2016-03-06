package com.easygame.sdk.repository.mapper.backend.ad;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.ad.NotificationAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.NotificationAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.NotificationAdShowVO;

public interface NotificationAdMapper {
	
	List<NotificationAdShowVO> selectNotificationAdListByCriteria(NotificationAdSearchCriteriaDTO criteria);
	
	int insertNotificationAd(NotificationAdModifyDTO record);
	
	int updateNotificationAd(NotificationAdModifyDTO record);
	
	int getNotificationAdListTotalCountByCriteria(NotificationAdSearchCriteriaDTO criteria);
	
	int deleteNotificationAdByPrimaryKey(Integer id);
	
	NotificationAdShowVO selectNotificationAdByPrimaryKey(Integer id);

	int checkIfNotificationAdExist(@Param("notificationAdName") String name, @Param("id") Integer id);
	
}
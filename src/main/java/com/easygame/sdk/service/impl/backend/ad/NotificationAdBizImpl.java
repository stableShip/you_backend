package com.easygame.sdk.service.impl.backend.ad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.ad.NotificationAdMapper;
import com.easygame.sdk.repository.model.dto.backend.ad.NotificationAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.NotificationAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.NotificationAdShowVO;
import com.easygame.sdk.service.api.backend.ad.INotificationAdBiz;

@Service(value = "notificationAdBiz")
public class NotificationAdBizImpl implements INotificationAdBiz {

	@Autowired
	private NotificationAdMapper notificationAdMapper;

	public List<NotificationAdShowVO> selectNotificationAdListByCriteria(NotificationAdSearchCriteriaDTO criteria) {
		return notificationAdMapper.selectNotificationAdListByCriteria(criteria);
	}

	public int insertNotificationAd(NotificationAdModifyDTO record) {
		return notificationAdMapper.insertNotificationAd(record);
	}

	@Override
	public int getNotificationAdListTotalCountByCriteria(NotificationAdSearchCriteriaDTO criteria) {
	
	    	return notificationAdMapper.getNotificationAdListTotalCountByCriteria(criteria);
	}

	@Override
	public int deleteNotificationAd(int id) {
	   
	    return notificationAdMapper.deleteNotificationAdByPrimaryKey(id);
	}

	@Override
	public NotificationAdShowVO selectNotificationAdAdForUpdate(int id) {
	   
	    return notificationAdMapper.selectNotificationAdByPrimaryKey(id);
	}

	@Override
	public int updateNotificationAd(NotificationAdModifyDTO notificationAd) {
	   int id=notificationAdMapper.updateNotificationAd(notificationAd);
	   return id;
	}

	@Override
	public int checkNotificationAdDuplication(String name, Integer id) {
	   
	    return notificationAdMapper.checkIfNotificationAdExist(name, id);
	}

}

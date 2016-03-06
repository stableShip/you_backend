package com.easygame.sdk.repository.mapper.webservices;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.NotificationAdResultVO;

public interface NotificationAdServiceMapper {

	NotificationAdResultVO getNotificationAdInformation(AdParamsDTO param);
	
	int insertNotificationAdDisplayRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);
	
	int insertNotificationAdClickRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);
	
	int insertNotificationAdDownloadRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);

}
package com.easygame.sdk.repository.mapper.webservices;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.BannerAdResultVO;

public interface BannerAdServiceMapper {

	BannerAdResultVO getBannerAdInformation(AdParamsDTO param);
	
	int insertBannerAdDisplayRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);
	
	int insertBannerAdClickRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);
	
	int insertBannerAdDownloadRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);

}
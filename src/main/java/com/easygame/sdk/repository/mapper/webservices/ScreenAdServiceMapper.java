package com.easygame.sdk.repository.mapper.webservices;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.ScreenAdResultVO;

public interface ScreenAdServiceMapper {

	ScreenAdResultVO getScreenAdInformation(AdParamsDTO param);
	
	int insertScreenAdDisplayRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);
	
	int insertScreenAdClickRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);
	
	int insertScreenAdDownloadRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);

}
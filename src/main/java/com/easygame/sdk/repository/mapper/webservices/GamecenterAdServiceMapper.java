package com.easygame.sdk.repository.mapper.webservices;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.webservices.AdParamsDTO;
import com.easygame.sdk.repository.model.vo.webservices.GamecenterAdResultVO;

public interface GamecenterAdServiceMapper {

	List<GamecenterAdResultVO> getGamecenterAdList();
	
	int insertGamecenterAdDisplayRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);
	
	int insertGamecenterAdClickRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);
	
	int insertGamecenterAdDownloadRecord(@Param("param")AdParamsDTO param, @Param("ip")String ip, @Param("creationDate")Date creationDate);

}
package com.easygame.sdk.repository.mapper.webservices;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.webservices.ActiveCountInOneDayResultDTO;
import com.easygame.sdk.repository.model.po.ActiveRecord;
import com.easygame.sdk.repository.model.vo.webservices.ActiveRecordVO;

public interface WebServicesMapper {

	int checkIpCountByCriteria(@Param("ip") String ip, @Param("appKey") String appKey);

	List<ActiveRecordVO> getActiveRecordListByCriteria(@Param("imei") String imei, @Param("appKey") String appKey);

	int insertActiveRecord(ActiveRecord record);

	int checkisSuccessActive(@Param("imei") String imei, @Param("appKey") String appKey);

	ActiveCountInOneDayResultDTO getOneDayStatisticsCountByAccount(@Param("account") String account, @Param("password") String password);

}
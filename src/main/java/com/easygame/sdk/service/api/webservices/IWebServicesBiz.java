package com.easygame.sdk.service.api.webservices;

import java.util.List;

import com.easygame.sdk.repository.model.dto.webservices.ActiveCountInOneDayResultDTO;
import com.easygame.sdk.repository.model.po.ActiveRecord;
import com.easygame.sdk.repository.model.vo.webservices.ActiveRecordVO;

public interface IWebServicesBiz {

	public int checkIpCountByCriteria(String ip, String appKey);

	public List<ActiveRecordVO> getActiveRecordListByCriteria(String imei,
			String appKey);

	public int insertActiveRecord(ActiveRecord record);

	public int checkisSuccessActive(String imei, String appKey);

	public ActiveCountInOneDayResultDTO getOneDayStatisticsCountByAccount(String account,String password);
	
}

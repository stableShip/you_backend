package com.easygame.sdk.service.impl.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.webservices.WebServicesMapper;
import com.easygame.sdk.repository.model.dto.webservices.ActiveCountInOneDayResultDTO;
import com.easygame.sdk.repository.model.po.ActiveRecord;
import com.easygame.sdk.repository.model.vo.webservices.ActiveRecordVO;
import com.easygame.sdk.service.api.webservices.IWebServicesBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "webServicesBiz")
public class WebServicesBizImpl extends BaseBizImpl implements IWebServicesBiz {

	@Autowired
	private WebServicesMapper webServicesMapper;

	public int checkIpCountByCriteria(String ip, String appKey) {
		
		return webServicesMapper.checkIpCountByCriteria(ip, appKey);
		
	}

	public List<ActiveRecordVO> getActiveRecordListByCriteria(String imei, String appKey) {
		
		return webServicesMapper.getActiveRecordListByCriteria(imei, appKey);
		
	}

	public int insertActiveRecord(ActiveRecord record) {
		
		return webServicesMapper.insertActiveRecord(record);
		
	}

	public int checkisSuccessActive(String imei, String appKey) {
		
		return webServicesMapper.checkisSuccessActive(imei, appKey);
		
	}

	public ActiveCountInOneDayResultDTO getOneDayStatisticsCountByAccount(String account, String password) {
		
		return webServicesMapper.getOneDayStatisticsCountByAccount(account,password);
		
	}

}

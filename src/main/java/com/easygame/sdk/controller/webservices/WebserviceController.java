package com.easygame.sdk.controller.webservices;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.easygame.sdk.common.util.InternetUtils;
import com.easygame.sdk.common.util.JSONUtils;
import com.easygame.sdk.common.util.MD5Utils;
import com.easygame.sdk.common.util.MemcachedUtils;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.webservices.ActiveCountInOneDayResultDTO;
import com.easygame.sdk.repository.model.dto.webservices.CPAActiveParamsDTO;
import com.easygame.sdk.repository.model.po.ActiveRecord;
import com.easygame.sdk.repository.model.vo.webservices.ActiveRecordVO;
import com.easygame.sdk.service.api.webservices.IWebServicesBiz;

@Controller
@RequestMapping(value = "/webserviceController")
public class WebserviceController extends BaseController {

	private final String IP_COUNT = "IP_COUNT";

	private final String IMEI_CHECK = "IMEI_CHECK";

	private final String ACTIVE_COUNT_BY_ACCOUNT = "ACTIVE_COUNT_BY_ACCOUNT";

	private final int TIMEOUT = 470;

	private final int ACTIVE_COUNT_BY_ACCOUNT_TIME = 14400;

	@Autowired
	private IWebServicesBiz webServicesBiz;

	@Autowired
	private MemcachedUtils memcachedUtils;

	/** cpa统计 */
	@RequestMapping(value = "/cpaActive", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String cpaActive(HttpServletRequest request, String params) {
		
		// params = "{\"appKey\":\"d31d07a0b0615ca3180314dd230247a3\",\"imei\":\"b\",\"encryptKey\":\"c\"}";
		if (params == null || "".equals(params)) {
			return "0";
		}
		
		try {
			CPAActiveParamsDTO paramObject = JSONUtils.objectMapper.readValue(params, CPAActiveParamsDTO.class);
			// 获取ip地址
			String ipAddress = InternetUtils.getIPAddress(request);
			if (ipAddress != null && !"".equals(ipAddress)) {
				// 获取ip地址相同的数据
				Integer ipCount = null;
				if (memcachedUtils.get(IP_COUNT + ipAddress + paramObject.getAppKey()) == null) {
					ipCount = webServicesBiz.checkIpCountByCriteria(ipAddress, paramObject.getAppKey());
					memcachedUtils.add(IP_COUNT + ipAddress + paramObject.getAppKey(), TIMEOUT, ipCount);
				} else {
					ipCount = memcachedUtils.get(IP_COUNT + ipAddress + paramObject.getAppKey());
				}
				
				if (ipCount < 50) {
					if (checkEncrypt(paramObject.getImei(), paramObject.getAppKey(), paramObject.getEncryptKey())) {
						// 获取imei跟appkey相同的数据
						List<ActiveRecordVO> records = null;
						if (memcachedUtils.get(IMEI_CHECK + paramObject.getImei() + paramObject.getAppKey()) == null) {
							records = webServicesBiz.getActiveRecordListByCriteria(paramObject.getImei(), paramObject.getAppKey());
							memcachedUtils.add(IMEI_CHECK + paramObject.getImei() + paramObject.getAppKey(), TIMEOUT, records);
						} else {
							records = memcachedUtils.get(IMEI_CHECK + paramObject.getImei() + paramObject.getAppKey());
						}
						
						if (records != null && records.size() < 12) {
							ActiveRecord activeRecord = new ActiveRecord();
							if (records.size() == 0) {
								activeRecord.setTime(5);
								activeRecord.setDayType(false);
							} else if (records.size() > 0) {
								ActiveRecord record = records.get(records.size() - 1);
								if ((System.currentTimeMillis() - record.getCreationDateBiginttype()) > TIMEOUT * 1000) {
									activeRecord.setDayType(record.getDayType());
									if (record.getTime() == 30 && record.getDayType() == true) { // 是最后一个
										return "0";
									} else {
										if (checkSameDate(record.getCreationDateDatetype())) { // 不是同一天
											if (webServicesBiz.checkisSuccessActive(paramObject.getImei(), paramObject.getAppKey()) < 1) {
												// 检测第一天是否激活成功
												return "0";
											}
											activeRecord.setTime(5);
											activeRecord.setDayType(true);
										} else { // 其它情况
											activeRecord.setTime(record.getTime() + 5);
										}
									}
								} else {
									return "0";
								}
							}
							activeRecord.setAppKey(paramObject.getAppKey());
							activeRecord.setImei(paramObject.getImei());
							activeRecord.setIp(ipAddress);
							activeRecord.setCreationDateBiginttype(System.currentTimeMillis());
							activeRecord.setCreationDateDatetype(new Date());
							// 插入数据
							webServicesBiz.insertActiveRecord(activeRecord);
							memcachedUtils.delete(IP_COUNT + ipAddress + paramObject.getAppKey());
							memcachedUtils.delete(IMEI_CHECK + paramObject.getImei() + paramObject.getAppKey());
							return "1";
						}
					}
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return "0";
		
	}

	/** cpa统计N */
	@RequestMapping(value = "/cpaActiveN", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String cpaActiveN(HttpServletRequest request, String params) {
		if (params == null || "".equals(params)) {
			return "0";
		}
		try {
			CPAActiveParamsDTO paramObject = JSONUtils.objectMapper.readValue(params, CPAActiveParamsDTO.class);
			// 获取ip地址
			String ipAddress = InternetUtils.getIPAddress(request);
			if (ipAddress != null && !"".equals(ipAddress)) {
				// 获取ip地址相同的数据
				Integer ipCount = null;
				if (memcachedUtils.get(IP_COUNT + ipAddress + paramObject.getAppKey()) == null) {
					ipCount = webServicesBiz.checkIpCountByCriteria(ipAddress, paramObject.getAppKey());
					memcachedUtils.add( IP_COUNT + ipAddress + paramObject.getAppKey(), TIMEOUT, ipCount);
				} else {
					ipCount = memcachedUtils.get(IP_COUNT + ipAddress + paramObject.getAppKey());
				}
				
				if (ipCount < 50) {
					if (checkEncrypt(paramObject.getImei(), paramObject.getAppKey(), paramObject.getEncryptKey())) {
						// 获取imei跟appkey相同的数据
						List<ActiveRecordVO> records = null;
						if (memcachedUtils.get(IMEI_CHECK + paramObject.getImei() + paramObject.getAppKey()) == null) {
							records = webServicesBiz.getActiveRecordListByCriteria(paramObject.getImei(), paramObject.getAppKey());
							memcachedUtils.add(IMEI_CHECK + paramObject.getImei() + paramObject.getAppKey(), TIMEOUT, records);
						} else {
							records = memcachedUtils.get(IMEI_CHECK + paramObject.getImei() + paramObject.getAppKey());
						}
						
						if (records != null && records.size() < 15) {
							ActiveRecord activeRecord = new ActiveRecord();
							if (records.size() == 0) {
								activeRecord.setTime(0);
								activeRecord.setDayType(false);
							} else if (records.size() > 0) {
								ActiveRecord record = records.get(records.size() - 1);
								if ((System.currentTimeMillis() - record.getCreationDateBiginttype()) > TIMEOUT * 1000) {
									activeRecord.setDayType(record.getDayType());
									if (record.getTime() == 30 && record.getDayType() == true) { // 是最后一个
										return "0";
									} else {
										if (checkSameDate(record.getCreationDateDatetype())) { // 不是同一天
											if (webServicesBiz.checkisSuccessActive(paramObject.getImei(), paramObject.getAppKey()) < 1) {
												// 检测第一天是否激活成功
												return "0";
											}
											activeRecord.setTime(0);
											activeRecord.setDayType(true);
										} else { // 其它情况
											activeRecord.setTime(record.getTime() + 5);
										}
									}
								} else {
									return "0";
								}
							}
							activeRecord.setAppKey(paramObject.getAppKey());
							activeRecord.setImei(paramObject.getImei());
							activeRecord.setIp(ipAddress);
							activeRecord.setCreationDateBiginttype(System.currentTimeMillis());
							activeRecord.setCreationDateDatetype(new Date());
							// 插入数据
							webServicesBiz.insertActiveRecord(activeRecord);
							memcachedUtils.delete(IP_COUNT + ipAddress + paramObject.getAppKey());
							memcachedUtils.delete(IMEI_CHECK + paramObject.getImei() + paramObject.getAppKey());
							return "1";
						}
					}
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "0";
	}

	public boolean checkEncrypt(String imei, String appKey, String encryptKey) {
		return encryptKey.equals(MD5Utils.getMD5Code(appKey.substring(0, 10) + "qsyx" + imei));
	}

	public boolean checkSameDate(Date oldDate) {
		
		if (new Date().getDay() != oldDate.getDay()) {
			return true;
		}
		
		return false;
		
	}

	@RequestMapping(value = "/getOneDayStatisticsCountByAccount", method = { RequestMethod.POST, RequestMethod.GET }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String getOneDayStatisticsCountByAccount(HttpServletRequest request, String account, String password) {
		
		ActiveCountInOneDayResultDTO result = null;
		// 当天的日期，当天的激活，当天统计的次日激活
		if (memcachedUtils.get(ACTIVE_COUNT_BY_ACCOUNT + account + password) == null) {
			result = webServicesBiz.getOneDayStatisticsCountByAccount(account, MD5Utils.getMD5Code(password));
			memcachedUtils.add(ACTIVE_COUNT_BY_ACCOUNT + account + password, ACTIVE_COUNT_BY_ACCOUNT_TIME, result);
		} else {
			result = memcachedUtils.get(ACTIVE_COUNT_BY_ACCOUNT + account + password);
		}
		
		return JSON.toJSONString(result);
		
	}

}
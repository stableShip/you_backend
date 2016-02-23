package com.easygame.sdk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class BaseBizImpl {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected void showJSONObject(Object object) {
		logger.debug(JSON.toJSONString(object));
	}

}

package com.easygame.sdk.service.impl.backend.general;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.common.util.MD5Utils;
import com.easygame.sdk.repository.mapper.backend.general.PasswordMapper;
import com.easygame.sdk.repository.model.dto.backend.general.PasswordModifyDTO;
import com.easygame.sdk.service.api.backend.general.IPasswordBiz;

@Service(value = "passwordBiz")
public class PasswordBizImpl implements IPasswordBiz {
	
	@Autowired
	private PasswordMapper passwordMapper;

	public int updatePassword(PasswordModifyDTO record, Integer id) {
		record.setId(id);
		record.setPassword(MD5Utils.getMD5Code(record.getPassword()));
		record.setLastUpdateDate(new Date());
		return passwordMapper.updatePassword(record);
	}

}
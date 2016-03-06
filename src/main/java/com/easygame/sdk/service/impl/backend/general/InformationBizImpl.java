package com.easygame.sdk.service.impl.backend.general;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.general.InformationMapper;
import com.easygame.sdk.repository.model.dto.backend.general.InformationModifyDTO;
import com.easygame.sdk.service.api.backend.general.IInformationBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "informationBiz")
public class InformationBizImpl extends BaseBizImpl implements IInformationBiz {

	@Autowired
	private InformationMapper informationMapper;

	public InformationModifyDTO selectAccountForUpdate(int id) {
		return informationMapper.selectAccountByPrimaryKey(id);
	}

	public void updateAccount(InformationModifyDTO record) {
		
		record.setLastUpdateDate(new Date());
		informationMapper.updateAccount(record);

		informationMapper.updateAccountInformation(record);
		
	}

}
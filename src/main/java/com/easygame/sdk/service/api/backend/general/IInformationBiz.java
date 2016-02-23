package com.easygame.sdk.service.api.backend.general;

import com.easygame.sdk.repository.model.dto.backend.general.InformationModifyDTO;

/** 修改个人信息业务 */
public interface IInformationBiz {

	/** 查找用户信息*/
	public InformationModifyDTO selectAccountForUpdate(int id);

	/** 更新个人信息*/
	public void updateAccount(InformationModifyDTO record);

}

package com.easygame.sdk.repository.mapper.backend.general;

import com.easygame.sdk.repository.model.dto.backend.general.InformationModifyDTO;

/** 修改个人信息DAO接口 */
public interface InformationMapper {

	/** 根据ID查找用户修改*/
	InformationModifyDTO selectAccountByPrimaryKey(Integer id);

	/** 更新用户 */
	int updateAccount(InformationModifyDTO record);

	/** 更新用户信息 */
	int updateAccountInformation(InformationModifyDTO record);

}

package com.easygame.sdk.service.api.backend.general;

import com.easygame.sdk.repository.model.dto.backend.general.PasswordModifyDTO;

public interface IPasswordBiz {
	
	public int updatePassword(PasswordModifyDTO record, Integer id);
}

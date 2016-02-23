package com.easygame.sdk.repository.mapper.backend.general;

import com.easygame.sdk.repository.model.dto.backend.general.PasswordModifyDTO;

public interface PasswordMapper {

	int updatePassword(PasswordModifyDTO record);

}

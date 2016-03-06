package com.easygame.sdk.repository.mapper.backend.general;

import com.easygame.sdk.repository.model.dto.backend.general.LoginDTO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountSessionVO;

/** 登录DAO接口 */
public interface LoginAndLogoutMapper {
	
	/** 根据条件查找用户 */
	AccountSessionVO selectByLoginDTO(LoginDTO record);

}

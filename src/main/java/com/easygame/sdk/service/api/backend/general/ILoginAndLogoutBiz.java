package com.easygame.sdk.service.api.backend.general;

import com.easygame.sdk.repository.model.dto.backend.general.LoginDTO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountSessionVO;

/** 登录业务 */
public interface ILoginAndLogoutBiz {

	/** 用户检测 */
	public AccountSessionVO getAdmin(LoginDTO admin);

}

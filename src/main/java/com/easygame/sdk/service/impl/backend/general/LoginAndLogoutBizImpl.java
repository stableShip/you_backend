package com.easygame.sdk.service.impl.backend.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.common.util.MD5Utils;
import com.easygame.sdk.repository.mapper.backend.general.LoginAndLogoutMapper;
import com.easygame.sdk.repository.model.dto.backend.general.LoginDTO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountSessionVO;
import com.easygame.sdk.service.api.backend.general.ILoginAndLogoutBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "loginAndlogoutBiz")
public class LoginAndLogoutBizImpl extends BaseBizImpl implements ILoginAndLogoutBiz{
	
	@Autowired
	private LoginAndLogoutMapper loginAndlogoutMapper;

	public AccountSessionVO getAdmin(LoginDTO admin) {
		admin.setPassword(MD5Utils.getMD5Code(admin.getPassword()));
		return loginAndlogoutMapper.selectByLoginDTO(admin);
	}

}

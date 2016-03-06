package com.easygame.sdk.repository.model.dto.backend.general;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.easygame.sdk.repository.model.po.Account;

public class PasswordModifyDTO extends Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "确认密码不能为空")
	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
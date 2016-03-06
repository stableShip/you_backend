package com.easygame.sdk.repository.model.dto.backend.general;

import java.io.Serializable;

import com.easygame.sdk.repository.model.po.Account;
import com.easygame.sdk.repository.model.po.AccountInformation;

public class AccountModifyDTO extends Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private AccountInformation accountInformation;

	public AccountInformation getAccountInformation() {
		return accountInformation;
	}

	public void setAccountInformation(AccountInformation accountInformation) {
		this.accountInformation = accountInformation;
	}

}
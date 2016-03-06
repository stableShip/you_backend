package com.easygame.sdk.service.impl.backend.general;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.common.util.MD5Utils;
import com.easygame.sdk.repository.mapper.backend.general.AccountMapper;
import com.easygame.sdk.repository.model.dto.backend.general.AccountModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.general.AccountSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;
import com.easygame.sdk.service.api.backend.general.IAccountBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "accountBiz")
public class AccountBizImpl extends BaseBizImpl implements IAccountBiz {

	@Autowired
	private AccountMapper accountMapper;

	public List<CompanyShowVO> selectAllCompany() {
		
		return accountMapper.selectAllCompany();
		
	}

	public int insertAccount(AccountModifyDTO record) {
		
		record.setPassword(MD5Utils.getMD5Code(record.getPassword()));
		record.setCreationDate(new Date());
		record.setLastUpdateDate(new Date());
		record.setLastUpdateLogin(new Date());
		accountMapper.insertAccount(record);

		return accountMapper.insertAccountInformation(record);
	}

	public List<AccountShowVO> selectAccountListByCriteria(AccountSearchCriteriaDTO criteria) {
		
		return accountMapper.selectAccountListByCriteria(criteria);
		
	}

	public int getAccountListTotalCountByCriteria(AccountSearchCriteriaDTO criteria) {
		
		return accountMapper.getAccountListTotalCountByCriteria(criteria);
		
	}

	public AccountModifyDTO selectAccountForUpdate(int id) {
		
		return accountMapper.selectAccountByPrimaryKey(id);
		
	}

	public int updateAccount(AccountModifyDTO record) {
		
		if (record.getPassword() != null) {
			
			record.setPassword(MD5Utils.getMD5Code(record.getPassword()));
			
		}
		
		record.setLastUpdateDate(new Date());
		accountMapper.updateAccount(record);

		return accountMapper.updateAccountInformation(record);
	}

	public int checkAccountDuplication(AccountModifyDTO record) {
		
		return accountMapper.checkIfAccountExist(record.getAccount(), record.getId());
		
	}
	
	public int deleteAccount(int id) {
		
		if (accountMapper.checkAccountDeleteSecurity(id) > 0) {
			
			return 0;
			
		}
		
		accountMapper.deleteAccountInformationByAccountId(id);
		
		return accountMapper.deleteAccountByPrimaryKey(id);
		
	}

}
package com.easygame.sdk.repository.mapper.backend.general;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.general.AccountModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.general.AccountSearchCriteriaDTO;
import com.easygame.sdk.repository.model.po.Account;
import com.easygame.sdk.repository.model.po.AccountInformation;
import com.easygame.sdk.repository.model.vo.backend.general.AccountShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;

/** 用户管理DAO接口 */
public interface AccountMapper {

	/** 检测用户是否重复 */
	int checkIfAccountExist(@Param("account") String account,
			@Param("id") Integer id);

	/** 添加用户 */
	int insertAccount(AccountModifyDTO record);

	int insertAccountInformation(AccountModifyDTO record);

	/** 获取所有公司 */
	List<CompanyShowVO> selectAllCompany();

	/** 根据条件查找用户 */
	List<AccountShowVO> selectAccountListByCriteria(AccountSearchCriteriaDTO criteria);

	/** 返回根据条件公司的总数 */
	int getAccountListTotalCountByCriteria(AccountSearchCriteriaDTO criteria);

	/** 根据ID查找公司 */
	AccountModifyDTO selectAccountByPrimaryKey(Integer id);

	/** 更新用户 */
	int updateAccount(AccountModifyDTO record);

	int updateAccountInformation(AccountModifyDTO record);

	/** 删除检测 */
	int checkAccountDeleteSecurity(Integer id);

	/** 删除用户 */
	int deleteAccountByPrimaryKey(Integer id);

	int deleteAccountInformationByAccountId(Integer accountId);

}
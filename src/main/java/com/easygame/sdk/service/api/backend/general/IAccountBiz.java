package com.easygame.sdk.service.api.backend.general;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.general.AccountModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.general.AccountSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;

/** 用户管理业务 */
public interface IAccountBiz {

	/** 获取所有公司 */
	public List<CompanyShowVO> selectAllCompany();
	
	/** 重复用户检测 */
	public int checkAccountDuplication(AccountModifyDTO record);
	
	/** 添加用户 */
	public int insertAccount(AccountModifyDTO record);
	
	/** 根据条件查找用户列表 */
	public List<AccountShowVO> selectAccountListByCriteria(AccountSearchCriteriaDTO criteria);
	
	/** 返回根据条件查找用户的总数 */
	public int getAccountListTotalCountByCriteria(AccountSearchCriteriaDTO criteria);
	
	/** 根据ID查找用户 */
	public AccountModifyDTO selectAccountForUpdate(int id);
	
	/** 更新用户 */
	public int updateAccount(AccountModifyDTO record);
	
	/** 删除用户 */
	public int deleteAccount(int id);
	
}

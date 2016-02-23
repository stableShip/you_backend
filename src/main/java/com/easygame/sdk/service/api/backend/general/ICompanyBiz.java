package com.easygame.sdk.service.api.backend.general;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.general.CompanyModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.general.CompanySearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;

/** 公司管理业务 */
public interface ICompanyBiz {

	/** 重复公司检测 */
	public int checkCompanyDuplication(CompanyModifyDTO record);

	/** 添加公司 */
	public int insertCompany(CompanyModifyDTO record);

	/** 根据条件查找公司列表 */
	public List<CompanyShowVO> selectCompanyListByCriteria(
			CompanySearchCriteriaDTO criteria);

	/** 返回根据条件查找公司的总数 */
	public int getCompanyListTotalCountByCriteria(
			CompanySearchCriteriaDTO criteria);

	/** 根据主键删除公司 */
	public int deleteCompanyByPrimaryKey(int id);

	/** 根据主键查找公司 */
	public CompanyModifyDTO selectCompanyForUpdate(int id);

	/** 更新公司信息 */
	public int updateCompany(CompanyModifyDTO record);

}

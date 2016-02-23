package com.easygame.sdk.repository.mapper.backend.general;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.general.CompanyModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.general.CompanySearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;

/** 公司管理DAO接口 */
public interface CompanyMapper {
	
	/** 检测公司是否重复 */
	int checkIfCompanyExist(@Param("name") String name, @Param("id") Integer id);

	/** 添加公司 */
	int insertCompany(CompanyModifyDTO record);

	/** 根据条件查找公司 */
	List<CompanyShowVO> selectCompanyListByCriteria(
			CompanySearchCriteriaDTO criteria);

	/** 返回根据条件查找公司的总数 */
	int getCompanyListTotalCountByCriteria(CompanySearchCriteriaDTO criteria);

	/** 根据ID删除公司 */
	int deleteCompanyByPrimaryKey(Integer id);

	/** 根据ID查找公司 */
	CompanyModifyDTO selectCompanyForUpdateByPrimaryKey(Integer id);

	/** 更新公司 */
	int updateCompany(CompanyModifyDTO record);

	/** 检测公司是否能删除 */
	int checkCompanyDeleteSecurity(Integer id);

}
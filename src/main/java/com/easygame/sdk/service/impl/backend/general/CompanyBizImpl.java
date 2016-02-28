package com.easygame.sdk.service.impl.backend.general;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.general.CompanyMapper;
import com.easygame.sdk.repository.model.dto.backend.general.CompanyModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.general.CompanySearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;
import com.easygame.sdk.service.api.backend.general.ICompanyBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "companyBiz")
public class CompanyBizImpl extends BaseBizImpl implements ICompanyBiz {

	@Autowired
	private CompanyMapper companyMapper;
	
	public int checkCompanyDuplication(CompanyModifyDTO record) {
		return companyMapper.checkIfCompanyExist(record.getName(), record.getId());
	}

	public int insertCompany(CompanyModifyDTO companyDto) {
		
		companyDto.setLastUpdateDate(new Date());
		companyDto.setCreationDate(new Date());
		return companyMapper.insertCompany(companyDto);
		
	}

	public List<CompanyShowVO> selectCompanyListByCriteria(CompanySearchCriteriaDTO criteria) {
		
		return companyMapper.selectCompanyListByCriteria(criteria);
		
	}

	public int getCompanyListTotalCountByCriteria(CompanySearchCriteriaDTO criteria) {
		
		return companyMapper.getCompanyListTotalCountByCriteria(criteria);
		
	}

	public int deleteCompanyByPrimaryKey(int id) {
		
		if (companyMapper.checkCompanyDeleteSecurity(id) > 0) {
			
			return 0;
			
		}
		
		return companyMapper.deleteCompanyByPrimaryKey(id);
	}

	public CompanyModifyDTO selectCompanyForUpdate(int id) {
		
		return companyMapper.selectCompanyForUpdateByPrimaryKey(id);
		
	}

	public int updateCompany(CompanyModifyDTO companyDto) {
		
		companyDto.setLastUpdateDate(new Date());
		
		return companyMapper.updateCompany(companyDto);
		
	}

}

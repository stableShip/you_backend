package com.easygame.sdk.repository.mapper.backend.toner;

import com.easygame.sdk.repository.model.dto.backend.toner.TonerModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.toner.TonerSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.toner.TonerShowVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 渠道业务DAO接口 */
public interface TonerMapper {

	/** 根据条件查找渠道 */
	List<TonerShowVO> selectTonerListByCriteria(TonerSearchCriteriaDTO criteria);

	/** 返回根据条件查找渠道总数 */
	int getTonerListTotalCountByCriteria(TonerSearchCriteriaDTO criteria);


	/** 检测渠道是否重复 */
	int checkIfTonerExist(@Param("name") String name, @Param("id") Integer id);

	int checkTonerDeleteSecurity(Integer id);

	int deleteTonerByPrimaryKey(Integer id);

	/** 添加渠道 */
	int insertToner(TonerModifyDTO record);

	/** 根据ID查找渠道 */
	TonerModifyDTO selectTonerByPrimaryKey(Integer id);

	int selectTonerMaxId();
	
	int updateToner(TonerModifyDTO record);
	
	List<TonerShowVO> selectAllToner();

}

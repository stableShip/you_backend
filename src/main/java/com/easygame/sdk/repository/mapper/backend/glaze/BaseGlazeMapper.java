package com.easygame.sdk.repository.mapper.backend.glaze;

import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.glaze.BaseGlazeShowVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 渠道业务DAO接口 */
public interface BaseGlazeMapper {

	/** 根据条件查找渠道 */
	List<BaseGlazeShowVO> selectBaseGlazeListByCriteria(BaseGlazeSearchCriteriaDTO criteria);

	/** 返回根据条件查找渠道总数 */
	int getBaseGlazeListTotalCountByCriteria(BaseGlazeSearchCriteriaDTO criteria);


	/** 检测渠道是否重复 */
	int checkIfBaseGlazeExist(@Param("name") String name, @Param("id") Integer id);

	int checkBaseGlazeDeleteSecurity(Integer id);

	int deleteBaseGlazeByPrimaryKey(Integer id);

	/** 添加渠道 */
	int insertBaseGlaze(BaseGlazeModifyDTO record);

	/** 根据ID查找渠道 */
	BaseGlazeModifyDTO selectBaseGlazeByPrimaryKey(Integer id);

	int selectBaseGlazeMaxId();
	
	int updateBaseGlaze(BaseGlazeModifyDTO record);
	
	List<BaseGlazeShowVO> selectAllBaseGlaze();

}

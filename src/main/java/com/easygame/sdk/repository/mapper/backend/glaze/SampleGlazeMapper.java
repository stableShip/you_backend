package com.easygame.sdk.repository.mapper.backend.glaze;

import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeSearchCriteriaDTO;
import com.easygame.sdk.repository.model.dto.backend.toner.TonerModifyDTO;
import com.easygame.sdk.repository.model.vo.backend.glaze.SampleGlazeShowVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 样品釉业务DAO接口 */
public interface SampleGlazeMapper {

	/** 根据条件查找样品釉 */
	List<SampleGlazeShowVO> selectSampleGlazeListByCriteria(SampleGlazeSearchCriteriaDTO criteria);

	/** 返回根据条件查找样品釉总数 */
	int getSampleGlazeListTotalCountByCriteria(SampleGlazeSearchCriteriaDTO criteria);


	/** 检测样品釉是否重复 */
	int checkIfSampleGlazeExist(@Param("name") String name, @Param("id") Integer id);

	int checkSampleGlazeDeleteSecurity(Integer id);

	int deleteSampleGlazeByPrimaryKey(Integer id);

	/** 添加样品釉 */
	int insertSampleGlaze(SampleGlazeModifyDTO record);

	/** 根据ID查找样品釉 */
	SampleGlazeModifyDTO selectSampleGlazeByPrimaryKey(Integer id);

	int selectSampleGlazeMaxId();
	
	int updateSampleGlaze(SampleGlazeModifyDTO record);
	
	List<SampleGlazeShowVO> selectAllSampleGlaze();

	/** 建立客户关联 */
	int buildCustomerConnect(SampleGlazeModifyDTO record);
	/** 建立基础釉关联 */
	int buildBaseGlazeConnect(BaseGlazeModifyDTO record);
	/** 建立色料关联 */
	int buildTonerConnect(TonerModifyDTO record);

	/** 删除客户关联 */
	int deleteCustomerConnect(@Param("id") Integer id);
	/** 删除基础釉关联 */
	int deleteBaseGlazeConnect(@Param("id") Integer id);
	/** 删除色料关联 */
	int deleteTonerConnect(@Param("id") Integer id);


}

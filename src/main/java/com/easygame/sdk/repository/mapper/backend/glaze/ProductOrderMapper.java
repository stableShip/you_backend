package com.easygame.sdk.repository.mapper.backend.glaze;

import com.easygame.sdk.repository.model.dto.backend.glaze.ProductOrderModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.ProductOrderSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.ProductOrderShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.SampleGlazeShowVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 渠道业务DAO接口 */
public interface ProductOrderMapper {

	/** 根据条件查找渠道 */
	List<ProductOrderShowVO> selectProductOrderListByCriteria(ProductOrderSearchCriteriaDTO criteria);

	/** 返回根据条件查找渠道总数 */
	int getProductOrderListTotalCountByCriteria(ProductOrderSearchCriteriaDTO criteria);


	/** 检测渠道是否重复 */
	int checkIfProductOrderExist(@Param("name") String name, @Param("id") Integer id);

	int checkProductOrderDeleteSecurity(Integer id);

	int deleteProductOrderByPrimaryKey(Integer id);

	/** 添加渠道 */
	int insertProductOrder(ProductOrderModifyDTO record);

	/** 根据ID查找渠道 */
	ProductOrderModifyDTO selectProductOrderByPrimaryKey(Integer id);

	int selectProductOrderMaxId();
	
	int updateProductOrder(ProductOrderModifyDTO record);
	
	List<ProductOrderShowVO> selectAllProductOrder();

	List<CompanyShowVO> getSampleGlazeCustomerList();

	List<SampleGlazeShowVO> getSampleGlazeListByCustomerId(@Param("id") Integer customerId);


}

package com.easygame.sdk.service.api.backend.glaze;

import com.easygame.sdk.repository.model.dto.backend.glaze.ProductOrderModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.ProductOrderSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.ProductOrderShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.SampleGlazeShowVO;

import java.util.List;

/**
 * 渠道业务接口
 */
public interface IProductOrderBiz {

    /**
     * 根据条件查找渠道
     */
    public List<ProductOrderShowVO> selectProductOrderListByCriteria(ProductOrderSearchCriteriaDTO criteria);

    /**
     * 返回根据条件查找渠道的总数
     */
    public int getProductOrderListTotalCountByCriteria(
            ProductOrderSearchCriteriaDTO criteria);

    /**
     * 检测渠道是否已经存在
     */
    public int checkProductOrderDuplication(String name, Integer id);

    public int deleteProductOrder(int id);

    /**
     * 插入渠道
     */
    public ProductOrderModifyDTO insertProductOrder(ProductOrderModifyDTO record);

    public ProductOrderModifyDTO selectProductOrderForUpdate(int id);

    public ProductOrderModifyDTO updateProductOrder(ProductOrderModifyDTO record);

    public List<ProductOrderShowVO> selectAllProductOrder();

    public List<CompanyShowVO> getCustomerOptions();

    public List<SampleGlazeShowVO> getSampleGlazeOptions(Integer customerId);


}

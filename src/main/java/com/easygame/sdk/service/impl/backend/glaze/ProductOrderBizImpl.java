package com.easygame.sdk.service.impl.backend.glaze;

import com.easygame.sdk.repository.mapper.backend.glaze.ProductOrderMapper;
import com.easygame.sdk.repository.model.dto.backend.glaze.ProductOrderModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.ProductOrderSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.general.CompanyShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.ProductOrderShowVO;
import com.easygame.sdk.repository.model.vo.backend.glaze.SampleGlazeShowVO;
import com.easygame.sdk.service.api.backend.glaze.IProductOrderBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "productOrderBiz")
public class ProductOrderBizImpl extends BaseBizImpl implements IProductOrderBiz {

    @Autowired
    private ProductOrderMapper productOrderMapper;

    public int checkIfProductOrderExist(String name, Integer id) {

        return productOrderMapper.checkIfProductOrderExist(name, id);

    }


    public List<ProductOrderShowVO> selectProductOrderListByCriteria(ProductOrderSearchCriteriaDTO criteria) {
        return productOrderMapper.selectProductOrderListByCriteria(criteria);

    }

    @Override
    public int checkProductOrderDuplication(String name, Integer id) {
        return productOrderMapper.checkIfProductOrderExist(name, id);
    };

    @Override
    public int deleteProductOrder(int id) {
        return productOrderMapper.deleteProductOrderByPrimaryKey(id);
    }

    @Override
    public ProductOrderModifyDTO insertProductOrder(ProductOrderModifyDTO record) {
        record.setCreation_date(new Date());
        productOrderMapper.insertProductOrder(record);
        return productOrderMapper.selectProductOrderByPrimaryKey(record.getId());
    }

    @Override
    public ProductOrderModifyDTO selectProductOrderForUpdate(int id) {
        return productOrderMapper.selectProductOrderByPrimaryKey(id);
    }

    @Override
    public ProductOrderModifyDTO updateProductOrder(ProductOrderModifyDTO record) {
        productOrderMapper.updateProductOrder(record);
        return productOrderMapper.selectProductOrderByPrimaryKey(record.getId());
    }

    @Override
    public List<ProductOrderShowVO> selectAllProductOrder() {
        return productOrderMapper.selectAllProductOrder();
    }

    public int getProductOrderListTotalCountByCriteria(ProductOrderSearchCriteriaDTO criteria) {
        return productOrderMapper.getProductOrderListTotalCountByCriteria(criteria);
    }


    public List<CompanyShowVO> getCustomerOptions() {
        return productOrderMapper.getSampleGlazeCustomerList();
    }

    @Override
    public List<SampleGlazeShowVO> getSampleGlazeOptions(Integer customerId) {
        return productOrderMapper.getSampleGlazeListByCustomerId(customerId);

    }



}

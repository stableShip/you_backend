package com.easygame.sdk.service.impl.backend.glaze;

import com.alibaba.fastjson.JSON;
import com.easygame.sdk.repository.mapper.backend.glaze.SampleGlazeMapper;
import com.easygame.sdk.repository.model.dto.backend.general.CompanyModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeSearchCriteriaDTO;
import com.easygame.sdk.repository.model.dto.backend.toner.TonerModifyDTO;
import com.easygame.sdk.repository.model.vo.backend.glaze.SampleGlazeShowVO;
import com.easygame.sdk.service.api.backend.glaze.ISampleGlazeBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "sampleGlazeBiz")
public class SampleGlazeBizImpl extends BaseBizImpl implements ISampleGlazeBiz {

    @Autowired
    private SampleGlazeMapper sampleGlazeMapper;

    public int checkIfSampleGlazeExist(String name, Integer id) {

        return sampleGlazeMapper.checkIfSampleGlazeExist(name, id);

    }


    public List<SampleGlazeShowVO> selectSampleGlazeListByCriteria(SampleGlazeSearchCriteriaDTO criteria) {
        return sampleGlazeMapper.selectSampleGlazeListByCriteria(criteria);

    }

    @Override
    public int checkSampleGlazeDuplication(String name, Integer id) {
        return sampleGlazeMapper.checkIfSampleGlazeExist(name, id);
    };

    @Override
    public int deleteSampleGlaze(int id) {
		if (sampleGlazeMapper.checkSampleGlazeDeleteSecurity(id) > 0) {

			return 0;

		}
        sampleGlazeMapper.deleteTonerConnect(id);
        sampleGlazeMapper.deleteBaseGlazeConnect(id);
        sampleGlazeMapper.deleteCustomerConnect(id);
        return sampleGlazeMapper.deleteSampleGlazeByPrimaryKey(id);
    }

    @Override
    public SampleGlazeModifyDTO insertSampleGlaze(SampleGlazeModifyDTO record) {
        record.setCreation_date(new Date());
        sampleGlazeMapper.insertSampleGlaze(record);
        List<TonerModifyDTO> toners = record.getToners();
        for (int i = 0; toners!=null && i < toners.size(); i++) {
            TonerModifyDTO toner = toners.get(i);
            if (toner.getId()!= null) {
                toner.setSampleGlazeId(record.getId());
                sampleGlazeMapper.buildTonerConnect(toner);
            }
        }
        List<BaseGlazeModifyDTO> baseGlazes = record.getBaseGlazes();
        for (int i = 0; baseGlazes!=null && i < baseGlazes.size(); i++) {
            BaseGlazeModifyDTO baseGlaze = baseGlazes.get(i);
            if (baseGlaze.getId()!= null) {
                baseGlaze.setSampleGlazeId(record.getId());
                sampleGlazeMapper.buildBaseGlazeConnect(baseGlaze);
            }
        }
        CompanyModifyDTO customer = record.getCustomer();
        if (customer.getId()!= null) {
            customer.setSampleGlazeId(record.getId());
            sampleGlazeMapper.buildCustomerConnect(customer);
        }
        SampleGlazeModifyDTO sampleGlaze = sampleGlazeMapper.selectSampleGlazeByPrimaryKey(record.getId());
        List<TonerModifyDTO> resutlToners = sampleGlazeMapper.getTonerConnects(record.getId());
        List<BaseGlazeModifyDTO> resutlBaseGlaze = sampleGlazeMapper.getBaseGlazeConnects(record.getId());
        CompanyModifyDTO resutlCustomer = sampleGlazeMapper.getCustomerConnects(record.getId());
        sampleGlaze.setToners(resutlToners);
        sampleGlaze.setBaseGlazes(resutlBaseGlaze);
        sampleGlaze.setCustomer(resutlCustomer);
        return sampleGlaze;
    }

    @Override
    public SampleGlazeModifyDTO selectSampleGlazeForUpdate(int id) {
        SampleGlazeModifyDTO sampleGlaze = sampleGlazeMapper.selectSampleGlazeByPrimaryKey(id);
        List<TonerModifyDTO> toners = sampleGlazeMapper.getTonerConnects(id);
        List<BaseGlazeModifyDTO> baseGlazes = sampleGlazeMapper.getBaseGlazeConnects(id);
        CompanyModifyDTO customer = sampleGlazeMapper.getCustomerConnects(id);
        sampleGlaze.setToners(toners);
        sampleGlaze.setBaseGlazes(baseGlazes);
        sampleGlaze.setCustomer(customer);
        return sampleGlaze;
    }

    @Override
    public SampleGlazeModifyDTO updateSampleGlaze(SampleGlazeModifyDTO record) {
        sampleGlazeMapper.updateSampleGlaze(record);
        Integer id = record.getId();
        sampleGlazeMapper.deleteTonerConnect(id);
        sampleGlazeMapper.deleteBaseGlazeConnect(id);
        sampleGlazeMapper.deleteCustomerConnect(id);
        List<TonerModifyDTO> toners = record.getToners();
        for (int i = 0; toners!=null && i < toners.size(); i++) {
            TonerModifyDTO toner = toners.get(i);
            if (toner.getId()!= null) {
                toner.setSampleGlazeId(record.getId());
                sampleGlazeMapper.buildTonerConnect(toner);
            }
        }
        List<BaseGlazeModifyDTO> baseGlazes = record.getBaseGlazes();
        for (int i = 0; baseGlazes!=null && i < baseGlazes.size(); i++) {
            BaseGlazeModifyDTO baseGlaze = baseGlazes.get(i);
            if (baseGlaze.getId()!= null) {
                baseGlaze.setSampleGlazeId(record.getId());
                sampleGlazeMapper.buildBaseGlazeConnect(baseGlaze);
            }
        }
        CompanyModifyDTO customer = record.getCustomer();
        if (customer.getId()!= null) {
            customer.setSampleGlazeId(record.getId());
            sampleGlazeMapper.buildCustomerConnect(customer);
        }
        SampleGlazeModifyDTO sampleGlaze = sampleGlazeMapper.selectSampleGlazeByPrimaryKey(record.getId());
        List<TonerModifyDTO> resutlToners = sampleGlazeMapper.getTonerConnects(record.getId());
        List<BaseGlazeModifyDTO> resutlBaseGlaze = sampleGlazeMapper.getBaseGlazeConnects(record.getId());
        CompanyModifyDTO resutlCustomer = sampleGlazeMapper.getCustomerConnects(record.getId());
        sampleGlaze.setToners(resutlToners);
        sampleGlaze.setBaseGlazes(resutlBaseGlaze);
        sampleGlaze.setCustomer(resutlCustomer);

        return sampleGlazeMapper.selectSampleGlazeByPrimaryKey(record.getId());
    }

    @Override
    public List<SampleGlazeShowVO> selectAllSampleGlaze() {
        return sampleGlazeMapper.selectAllSampleGlaze();
    }

    public int getSampleGlazeListTotalCountByCriteria(SampleGlazeSearchCriteriaDTO criteria) {
        return sampleGlazeMapper.getSampleGlazeListTotalCountByCriteria(criteria);
    }

}

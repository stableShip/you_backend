package com.easygame.sdk.service.impl.backend.glaze;

import com.easygame.sdk.repository.mapper.backend.glaze.SampleGlazeMapper;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.glaze.SampleGlazeShowVO;
import com.easygame.sdk.service.api.backend.glaze.ISampleGlazeBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // todo 检测是否有投料单存在
//		if (sampleGlazeMapper.checkSampleGlazeDeleteSecurity(id) > 0) {
//
//			return 0;
//
//		}
        sampleGlazeMapper.deleteTonerConnect(id);
        sampleGlazeMapper.deleteBaseGlazeConnect(id);
        sampleGlazeMapper.deleteCustomerConnect(id);
        return sampleGlazeMapper.deleteSampleGlazeByPrimaryKey(id);
    }

    @Override
    public SampleGlazeModifyDTO insertSampleGlaze(SampleGlazeModifyDTO record) {
        sampleGlazeMapper.insertSampleGlaze(record);
        return sampleGlazeMapper.selectSampleGlazeByPrimaryKey(record.getId());
    }

    @Override
    public SampleGlazeModifyDTO selectSampleGlazeForUpdate(int id) {
        return sampleGlazeMapper.selectSampleGlazeByPrimaryKey(id);
    }

    @Override
    public SampleGlazeModifyDTO updateSampleGlaze(SampleGlazeModifyDTO record) {
        sampleGlazeMapper.updateSampleGlaze(record);
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

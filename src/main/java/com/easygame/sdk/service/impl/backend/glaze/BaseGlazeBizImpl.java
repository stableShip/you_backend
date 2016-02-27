package com.easygame.sdk.service.impl.backend.glaze;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.glaze.BaseGlazeMapper;
import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.glaze.BaseGlazeShowVO;
import com.easygame.sdk.service.api.backend.glaze.IBaseGlazeBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "baseGlazeBiz")
public class BaseGlazeBizImpl extends BaseBizImpl implements IBaseGlazeBiz {

    @Autowired
    private BaseGlazeMapper baseGlazeMapper;

    public int checkIfBaseGlazeExist(String name, Integer id) {

        return baseGlazeMapper.checkIfBaseGlazeExist(name, id);

    }


    public List<BaseGlazeShowVO> selectBaseGlazeListByCriteria(BaseGlazeSearchCriteriaDTO criteria) {
        return baseGlazeMapper.selectBaseGlazeListByCriteria(criteria);

    }

    @Override
    public int checkBaseGlazeDuplication(String name, Integer id) {
        return 0;
    }

    @Override
    public int deleteBaseGlaze(int id) {

//		if (baseGlazeMapper.checkBaseGlazeDeleteSecurity(id) > 0) {
//
//			return 0;
//
//		}
        return baseGlazeMapper.deleteBaseGlazeByPrimaryKey(id);
    }

    @Override
    public BaseGlazeModifyDTO insertBaseGlaze(BaseGlazeModifyDTO record) {
        baseGlazeMapper.insertBaseGlaze(record);
        return baseGlazeMapper.selectBaseGlazeByPrimaryKey(record.getId());
    }

    @Override
    public BaseGlazeModifyDTO selectBaseGlazeForUpdate(int id) {
        return baseGlazeMapper.selectBaseGlazeByPrimaryKey(id);
    }

    @Override
    public BaseGlazeModifyDTO updateBaseGlaze(BaseGlazeModifyDTO record) {
        baseGlazeMapper.updateBaseGlaze(record);
        return baseGlazeMapper.selectBaseGlazeByPrimaryKey(record.getId());
    }

    @Override
    public List<BaseGlazeShowVO> selectAllBaseGlaze() {
        return baseGlazeMapper.selectAllBaseGlaze();
    }

    public int getBaseGlazeListTotalCountByCriteria(BaseGlazeSearchCriteriaDTO criteria) {
        return baseGlazeMapper.getBaseGlazeListTotalCountByCriteria(criteria);
    }

}

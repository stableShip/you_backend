package com.easygame.sdk.service.impl.backend.toner;

import com.easygame.sdk.repository.mapper.backend.toner.TonerMapper;
import com.easygame.sdk.repository.model.dto.backend.toner.TonerModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.toner.TonerSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.toner.TonerShowVO;
import com.easygame.sdk.service.api.backend.toner.ITonerBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "tonerBiz")
public class TonerBizImpl extends BaseBizImpl implements ITonerBiz {

    @Autowired
    private TonerMapper tonerMapper;

    public int checkIfTonerExist(String name, Integer id) {

        return tonerMapper.checkIfTonerExist(name, id);

    }


    public List<TonerShowVO> selectTonerListByCriteria(TonerSearchCriteriaDTO criteria) {
        return tonerMapper.selectTonerListByCriteria(criteria);

    }

    @Override
    public int checkTonerDuplication(String name, Integer id) {
        return tonerMapper.checkIfTonerExist(name, id);
    };

    @Override
    public int deleteToner(int id) {

//		if (tonerMapper.checkTonerDeleteSecurity(id) > 0) {
//
//			return 0;
//
//		}
        return tonerMapper.deleteTonerByPrimaryKey(id);
    }

    @Override
    public TonerModifyDTO insertToner(TonerModifyDTO record) {
        tonerMapper.insertToner(record);
        return tonerMapper.selectTonerByPrimaryKey(record.getId());
    }

    @Override
    public TonerModifyDTO selectTonerForUpdate(int id) {
        return tonerMapper.selectTonerByPrimaryKey(id);
    }

    @Override
    public TonerModifyDTO updateToner(TonerModifyDTO record) {
        tonerMapper.updateToner(record);
        return tonerMapper.selectTonerByPrimaryKey(record.getId());
    }

    @Override
    public List<TonerShowVO> selectAllToner() {
        return tonerMapper.selectAllToner();
    }

    public int getTonerListTotalCountByCriteria(TonerSearchCriteriaDTO criteria) {
        return tonerMapper.getTonerListTotalCountByCriteria(criteria);
    }

}

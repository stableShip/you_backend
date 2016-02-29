package com.easygame.sdk.service.api.backend.toner;

import com.easygame.sdk.repository.model.dto.backend.toner.TonerModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.toner.TonerSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.toner.TonerShowVO;

import java.util.List;

/**
 * 渠道业务接口
 */
public interface ITonerBiz {

    /**
     * 根据条件查找渠道
     */
    public List<TonerShowVO> selectTonerListByCriteria(TonerSearchCriteriaDTO criteria);

    /**
     * 返回根据条件查找渠道的总数
     */
    public int getTonerListTotalCountByCriteria(
            TonerSearchCriteriaDTO criteria);

    /**
     * 检测渠道是否已经存在
     */
    public int checkTonerDuplication(String name, Integer id);

    public int deleteToner(int id);

    /**
     * 插入渠道
     */
    public TonerModifyDTO insertToner(TonerModifyDTO record);

    public TonerModifyDTO selectTonerForUpdate(int id);

    public TonerModifyDTO updateToner(TonerModifyDTO record);

    public List<TonerShowVO> selectAllToner();

}

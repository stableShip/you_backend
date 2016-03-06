package com.easygame.sdk.service.api.backend.glaze;

import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.BaseGlazeSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.glaze.BaseGlazeShowVO;

import java.util.List;

/**
 * 渠道业务接口
 */
public interface IBaseGlazeBiz {

    /**
     * 根据条件查找渠道
     */
    public List<BaseGlazeShowVO> selectBaseGlazeListByCriteria(BaseGlazeSearchCriteriaDTO criteria);

    /**
     * 返回根据条件查找渠道的总数
     */
    public int getBaseGlazeListTotalCountByCriteria(
            BaseGlazeSearchCriteriaDTO criteria);

    /**
     * 检测渠道是否已经存在
     */
    public int checkBaseGlazeDuplication(String name, Integer id);

    public int deleteBaseGlaze(int id);

    /**
     * 插入渠道
     */
    public BaseGlazeModifyDTO insertBaseGlaze(BaseGlazeModifyDTO record);

    public BaseGlazeModifyDTO selectBaseGlazeForUpdate(int id);

    public BaseGlazeModifyDTO updateBaseGlaze(BaseGlazeModifyDTO record);

    public List<BaseGlazeShowVO> selectAllBaseGlaze();

}

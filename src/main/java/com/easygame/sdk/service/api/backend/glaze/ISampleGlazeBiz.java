package com.easygame.sdk.service.api.backend.glaze;

import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.glaze.SampleGlazeSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.glaze.SampleGlazeShowVO;

import java.util.List;

/**
 * 渠道业务接口
 */
public interface ISampleGlazeBiz {

    /**
     * 根据条件查找渠道
     */
    public List<SampleGlazeShowVO> selectSampleGlazeListByCriteria(SampleGlazeSearchCriteriaDTO criteria);

    /**
     * 返回根据条件查找渠道的总数
     */
    public int getSampleGlazeListTotalCountByCriteria(
            SampleGlazeSearchCriteriaDTO criteria);

    /**
     * 检测渠道是否已经存在
     */
    public int checkSampleGlazeDuplication(String name, Integer id);

    public int deleteSampleGlaze(int id);

    /**
     * 插入渠道
     */
    public SampleGlazeModifyDTO insertSampleGlaze(SampleGlazeModifyDTO record);

    public SampleGlazeModifyDTO selectSampleGlazeForUpdate(int id);

    public SampleGlazeModifyDTO updateSampleGlaze(SampleGlazeModifyDTO record);

    public List<SampleGlazeShowVO> selectAllSampleGlaze();

}

package com.easygame.sdk.repository.mapper.backend.channel;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionSearchCriteriaDTO;
import com.easygame.sdk.repository.model.po.CPAPromotion;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppShowVO;

/** 推广管理DAO接口 */
public interface CPAPromotionMapper {

	/** 检测是否已经存在推广 */
	int checkIfPromotionExist(@Param("channelId") Integer channelId, @Param("appId") Integer appId, @Param("appNickName") String appNickName, @Param("id") Integer id);

	/** 获取所有应用 */
	List<AppShowVO> selectAllApp();

	/** 添加推广 */
	int insertPromotion(CPAPromotionModifyDTO record);

	/** 根据ID查找推广 */
	CPAPromotionModifyDTO selectPromotionByPrimaryKey(Integer id);

	/** 更新推广 */
	int updatePromotion(CPAPromotionModifyDTO record);

	/** 根据条件查找推广 */
	List<CPAPromotionShowVO> selectPromotionListByCriteria(CPAPromotionSearchCriteriaDTO criteria);

	/** 返回根据条件查找推广总数 */
	int getPromotionListTotalCountByCriteria(CPAPromotionSearchCriteriaDTO criteria);

	/** 删除推广 */
	int deletePromotion(Integer id);
	
	int checkPromotionDeleteSecurity(Integer id);

	CPAPromotion selectPromotionEntityByPrimaryKey(Integer id);

	/** 获取应用序列 */
	int getAppSequenceByAppId(Integer appId);

	/** 更新应用序列 */
	int updateAppSequence(@Param("appId") Integer appId, @Param("nextVal") Integer nextVal);

}
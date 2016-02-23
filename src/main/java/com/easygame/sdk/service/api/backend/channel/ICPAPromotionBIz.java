package com.easygame.sdk.service.api.backend.channel;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.ChannelShowVO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppShowVO;

/** 推广业务接口 */
public interface ICPAPromotionBIz {

	/** 获取所有渠道 */
	public List<ChannelShowVO> selectAllChannel();

	/** 获取所有应用 */
	public List<AppShowVO> selectAllApp();

	/** 添加推广 */
	public CPAPromotionModifyDTO insertPromotion(CPAPromotionModifyDTO record,
			int adminId);

	/** 查找推广 */
	public CPAPromotionModifyDTO selectPromotionForUpdate(Integer id);

	/** 更新推广 */
	public CPAPromotionModifyDTO updatePromotion(CPAPromotionModifyDTO record,
			int adminId);

	/** 根据条件查找推广 */
	public List<CPAPromotionShowVO> selectPromotionListByCriteria(
			CPAPromotionSearchCriteriaDTO criteria);

	/** 返回根据条件查找推广总数 */
	public int getPromotionListTotalCountByCriteria(
			CPAPromotionSearchCriteriaDTO criteria);

	/** 删除推广 */
	public int deletePromotion(int id, int adminId);

	/** 检测推广是否重复 */
	public int checkPromotionDuplication(CPAPromotionModifyDTO record);

}

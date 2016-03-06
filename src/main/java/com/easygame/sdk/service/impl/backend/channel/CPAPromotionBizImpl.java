package com.easygame.sdk.service.impl.backend.channel;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.common.util.MD5Utils;
import com.easygame.sdk.repository.mapper.backend.channel.CPAPromotionLogMapper;
import com.easygame.sdk.repository.mapper.backend.channel.CPAPromotionMapper;
import com.easygame.sdk.repository.mapper.backend.channel.ChannelMapper;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.channel.CPAPromotionSearchCriteriaDTO;
import com.easygame.sdk.repository.model.dto.backend.channel.ChannelModifyDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.CPAPromotionShowVO;
import com.easygame.sdk.repository.model.vo.backend.channel.ChannelShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppShowVO;
import com.easygame.sdk.service.api.backend.channel.ICPAPromotionBIz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "promotionBiz")
public class CPAPromotionBizImpl extends BaseBizImpl implements ICPAPromotionBIz {

	@Autowired
	private CPAPromotionMapper promotionMapper;

	@Autowired
	private ChannelMapper channelMapper;

	@Autowired
	private CPAPromotionLogMapper promotionLogMapper;

	public List<ChannelShowVO> selectAllChannel() {
		return channelMapper.selectAllChannel();
	}

	public List<AppShowVO> selectAllApp() {
		return promotionMapper.selectAllApp();
	}

	public CPAPromotionModifyDTO insertPromotion(CPAPromotionModifyDTO record, int adminId) {
		
		ChannelModifyDTO channel = channelMapper.selectChannelByPrimaryKey(record.getChannelId());
		int nextVal = promotionMapper.getAppSequenceByAppId(record.getAppId());
		record.setCode(channel.getCode() + (100000 + record.getAppId()) + (10000 + nextVal));
		record.setAppKey(MD5Utils.getMD5Code(record.getCode()));
		record.setLastUpdateDate(new Date());
		record.setCreationDate(new Date());
		
		showJSONObject(record);
		promotionMapper.insertPromotion(record);
		promotionMapper.updateAppSequence(record.getAppId(), nextVal + 1);

		return promotionMapper.selectPromotionByPrimaryKey(record.getId());
	}

	public CPAPromotionModifyDTO selectPromotionForUpdate(Integer id) {
		return promotionMapper.selectPromotionByPrimaryKey(id);
	}

	public CPAPromotionModifyDTO updatePromotion(CPAPromotionModifyDTO record, int adminId) {
		
		record.setLastUpdateDate(new Date());
		promotionMapper.updatePromotion(record);
		
		return promotionMapper.selectPromotionByPrimaryKey(record.getId());
		
	}

	public List<CPAPromotionShowVO> selectPromotionListByCriteria(CPAPromotionSearchCriteriaDTO criteria) {
		
		return promotionMapper.selectPromotionListByCriteria(criteria);
		
	}

	public int deletePromotion(int id, int adminId) {
		
		if (promotionMapper.checkPromotionDeleteSecurity(id) > 0) {
			
			return 0;
			
		}
		
		promotionMapper.selectPromotionEntityByPrimaryKey(id);
		
		return promotionMapper.deletePromotion(id);
		
	}

	public int getPromotionListTotalCountByCriteria(CPAPromotionSearchCriteriaDTO criteria) {
		return promotionMapper.getPromotionListTotalCountByCriteria(criteria);
	}

	public int checkPromotionDuplication(CPAPromotionModifyDTO record) {
		
		return promotionMapper.checkIfPromotionExist(record.getChannelId(), record.getAppId(), record.getAppNickname(), record.getId());
		
	}
}

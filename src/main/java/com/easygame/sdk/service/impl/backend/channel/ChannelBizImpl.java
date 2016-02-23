package com.easygame.sdk.service.impl.backend.channel;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.channel.ChannelMapper;
import com.easygame.sdk.repository.model.dto.backend.channel.ChannelModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.channel.ChannelSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.ChannelShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountShowVO;
import com.easygame.sdk.service.api.backend.channel.IChannelBiz;
import com.easygame.sdk.service.impl.BaseBizImpl;

@Service(value = "channelBiz")
public class ChannelBizImpl extends BaseBizImpl implements IChannelBiz {

	@Autowired
	private ChannelMapper channelMapper;

	public int checkChannelDuplication(String name,Integer id) {
		
		return channelMapper.checkIfChannelExist(name,id);
		
	}

	public List<AccountShowVO> selectAllAdmin() {
		
		return channelMapper.selectAllAccount();
		
	}

	public List<ChannelShowVO> selectChannelListByCriteria(ChannelSearchCriteriaDTO criteria) {
		
		return channelMapper.selectChannelListByCriteria(criteria);
		
	}

	public int getChannelListTotalCountByCriteria(ChannelSearchCriteriaDTO criteria) {
		
		return channelMapper.getChannelListTotalCountByCriteria(criteria);
		
	}

	public int deleteChannel(int id) {
		
		if (channelMapper.checkChannelDeleteSecurity(id) > 0) {
			
			return 0;
			
		}
		
		return channelMapper.deleteChannelByPrimaryKey(id);
		
	}

	public ChannelModifyDTO insertChannel(ChannelModifyDTO record) {
		
		record.setCode(String.format("%05d", channelMapper.selectChannelMaxId() + 1));
		record.setCreationDate(new Date());
		channelMapper.insertChannel(record);
		
		return channelMapper.selectChannelByPrimaryKey(record.getId());
	}

	public ChannelModifyDTO selectChannelForUpdate(int id) {
		
		return channelMapper.selectChannelByPrimaryKey(id);
		
	}

	public ChannelModifyDTO updateChannel(ChannelModifyDTO record) {
		
		channelMapper.updateChannel(record);
		
		return channelMapper.selectChannelByPrimaryKey(record.getId());
		
	}

	public List<ChannelShowVO> selectAllChannel() {
		
		return channelMapper.selectAllChannel();
		
	}

}

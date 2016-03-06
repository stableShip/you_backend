package com.easygame.sdk.service.api.backend.channel;

import java.util.List;

import com.easygame.sdk.repository.model.dto.backend.channel.ChannelModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.channel.ChannelSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.ChannelShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountShowVO;

/** 渠道业务接口 */
public interface IChannelBiz {

	/** 根据条件查找渠道 */
	public List<ChannelShowVO> selectChannelListByCriteria(
			ChannelSearchCriteriaDTO criteria);

	/** 返回根据条件查找渠道的总数 */
	public int getChannelListTotalCountByCriteria(
			ChannelSearchCriteriaDTO criteria);

	/** 获取所有用户 */
	public List<AccountShowVO> selectAllAdmin();

	/** 检测渠道是否已经存在 */
	public int checkChannelDuplication(String name,Integer id);

	public int deleteChannel(int id);

	/** 插入渠道 */
	public ChannelModifyDTO insertChannel(ChannelModifyDTO record);

	public ChannelModifyDTO selectChannelForUpdate(int id);
	
	public ChannelModifyDTO updateChannel(ChannelModifyDTO record);
	
	public List<ChannelShowVO> selectAllChannel();

}

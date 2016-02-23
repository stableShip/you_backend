package com.easygame.sdk.repository.mapper.backend.channel;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygame.sdk.repository.model.dto.backend.channel.ChannelModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.channel.ChannelSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.channel.ChannelShowVO;
import com.easygame.sdk.repository.model.vo.backend.general.AccountShowVO;

/** 渠道业务DAO接口 */
public interface ChannelMapper {

	/** 根据条件查找渠道 */
	List<ChannelShowVO> selectChannelListByCriteria(ChannelSearchCriteriaDTO criteria);

	/** 返回根据条件查找渠道总数 */
	int getChannelListTotalCountByCriteria(ChannelSearchCriteriaDTO criteria);

	/** 获取所有用户 */
	List<AccountShowVO> selectAllAccount();

	/** 检测渠道是否重复 */
	int checkIfChannelExist(@Param("channelName") String channelName, @Param("id") Integer id);

	int checkChannelDeleteSecurity(Integer id);

	int deleteChannelByPrimaryKey(Integer id);

	/** 添加渠道 */
	int insertChannel(ChannelModifyDTO record);

	/** 根据ID查找渠道 */
	ChannelModifyDTO selectChannelByPrimaryKey(Integer id);

	int selectChannelMaxId();
	
	int updateChannel(ChannelModifyDTO record);
	
	List<ChannelShowVO> selectAllChannel();

}

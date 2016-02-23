package com.easygame.sdk.service.impl.backend.ad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.ad.ScreenAdMapper;
import com.easygame.sdk.repository.model.dto.backend.ad.ScreenAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.ScreenAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.ScreenAdShowVO;
import com.easygame.sdk.service.api.backend.ad.IScreenAdBiz;

@Service(value = "screenAdBiz")
public class ScreenAdBizImpl implements IScreenAdBiz {
	
    
	@Autowired
	private ScreenAdMapper screenAdMapper;
	
	public List<ScreenAdShowVO> selectScreenAdListByCriteria(ScreenAdSearchCriteriaDTO criteria) {
		return screenAdMapper.selectScreenAdListByCriteria(criteria);
	}

	
	public ScreenAdShowVO selectScreenAdForUpdate(int id) {
		return screenAdMapper.selectScreenAdByPrimaryKey(id);
	}
	
	/**
	 * 插入screenAd
	 */
	@Override
	public ScreenAdShowVO insertScreenAd(ScreenAdModifyDTO record) {
		// TODO Auto-generated method stub
		screenAdMapper.insertScreenAd(record);
		return 	screenAdMapper.selectScreenAdByPrimaryKey(record.getId());
	}
	
	/**
	 * 删除screenAd
	 */
	@Override
	public int deleteScreenAd(int id) {
	    int flag=screenAdMapper.deleteScreenAdByPrimaryKey(id);
	    return flag;
	}
	
	
	/**
	 * 更新screenAd
	 */
	public int updateScreenAd(ScreenAdModifyDTO record){
		int flag=screenAdMapper.updateScreenAd(record);
		
		return flag;
	}

	/**
	 * 获取screenAd总数目
	 */
	@Override
	public int getScreenAdListTotalCountByCriteria(	ScreenAdSearchCriteriaDTO criteria) {
		
		return screenAdMapper.getScreenAdListTotalCountByCriteria(criteria);
	}

	/**
	 * 验证screenAd是否存在
	 */
	@Override
	public int checkScreenAdDuplication(String name, int id) {
		// TODO Auto-generated method stub
		return screenAdMapper.checkIfScreenAdExist(name, id);
	}



	
}

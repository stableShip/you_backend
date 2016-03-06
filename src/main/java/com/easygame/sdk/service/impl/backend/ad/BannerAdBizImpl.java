package com.easygame.sdk.service.impl.backend.ad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.ad.BannerAdMapper;
import com.easygame.sdk.repository.model.dto.backend.ad.BannerAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.BannerAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.BannerAdShowVO;
import com.easygame.sdk.service.api.backend.ad.IBannerAdBiz;

@Service(value = "bannerAdBiz")
public class BannerAdBizImpl implements IBannerAdBiz {
	
    
	@Autowired
	private BannerAdMapper bannerAdMapper;
	
	public List<BannerAdShowVO> selectBannerAdListByCriteria(BannerAdSearchCriteriaDTO criteria) {
		return bannerAdMapper.selectBannerAdListByCriteria(criteria);
	}

	
	public BannerAdShowVO selectBannerAdForUpdate(int id) {
		return bannerAdMapper.selectBannerAdByPrimaryKey(id);
	}
	
	/**
	 * 插入bannerAd
	 */
	@Override
	public BannerAdShowVO insertBannerAd(BannerAdModifyDTO record) {
		// TODO Auto-generated method stub
		bannerAdMapper.insertBannerAd(record);
		return 	bannerAdMapper.selectBannerAdByPrimaryKey(record.getId());
	}
	
	/**
	 * 删除bannerAd
	 */
	@Override
	public int deleteBannerAd(int id) {
	    int flag=bannerAdMapper.deleteBannerAdByPrimaryKey(id);
	    return flag;
	}
	
	
	/**
	 * 更新bannerAd
	 */
	public int updateBannerAd(BannerAdModifyDTO record){
		int flag=bannerAdMapper.updateBannerAd(record);
		
		return flag;
	}

	/**
	 * 获取bannerAd总数目
	 */
	@Override
	public int getBannerAdListTotalCountByCriteria(	BannerAdSearchCriteriaDTO criteria) {
		
		return bannerAdMapper.getBannerAdListTotalCountByCriteria(criteria);
	}

	/**
	 * 验证bannerAd是否存在
	 */
	@Override
	public int checkBannerAdDuplication(String name, int id) {
		// TODO Auto-generated method stub
		return bannerAdMapper.checkIfBannerAdExist(name, id);
	}



	
}

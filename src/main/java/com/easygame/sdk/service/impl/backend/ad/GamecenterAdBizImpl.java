package com.easygame.sdk.service.impl.backend.ad;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygame.sdk.repository.mapper.backend.ad.GamecenterAdMapper;
import com.easygame.sdk.repository.model.dto.backend.ad.GamecenterAdModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.ad.search.GamecenterAdSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.ad.GamecenterAdShowVO;
import com.easygame.sdk.service.api.backend.ad.IGamecenterAdBiz;

@Service(value = "gamecenterAdBiz")
public class GamecenterAdBizImpl implements IGamecenterAdBiz {

    @Autowired
    private GamecenterAdMapper gamecenterAdMapper;

    public List<GamecenterAdShowVO> selectGamecenterAdListByCriteria(GamecenterAdSearchCriteriaDTO criteria) {
	return gamecenterAdMapper.selectGamecenterAdListByCriteria(criteria);
    }

    public GamecenterAdShowVO selectGamecenterAdForUpdate(int id) {
	return gamecenterAdMapper.selectGamecenterAdByPrimaryKey(id);
    }

    /**
     * 插入gamecenterAd
     * 判断是否设置了showIndex
     * true：插入并修改其他数据的showIndex
     * false：将其showIndex设置为MaxShowIndex
     */
   
    public GamecenterAdShowVO insertGamecenterAd(GamecenterAdModifyDTO gamecenterAd) {
	
	if(gamecenterAd.getShowIndex()==null||"".equals(gamecenterAd.getShowIndex())){
	    int showIndex=gamecenterAdMapper.selectGamecenterAdMaxShowIndex()+1;
	    gamecenterAd.setShowIndex(showIndex);
	}else {
	    int showIndex=gamecenterAd.getShowIndex();
	    if(gamecenterAdMapper.checkIfShowIndexExist(showIndex) > 0){
		gamecenterAd.setShowIndex(gamecenterAdMapper.selectGamecenterAdMaxShowIndex()+1);
		gamecenterAdMapper.insertGamecenterAd(gamecenterAd);
		gamecenterAd.setOriginalIndex(gamecenterAd.getShowIndex());
		gamecenterAd.setShowIndex(showIndex);
		this.updateShowIndex(gamecenterAd);
		return gamecenterAdMapper.selectGamecenterAdByPrimaryKey(gamecenterAd.getId());
	    }
	}
	gamecenterAdMapper.insertGamecenterAd(gamecenterAd);
	return gamecenterAdMapper.selectGamecenterAdByPrimaryKey(gamecenterAd.getId());
    }

    /**
     * 删除gamecenterAd
     */
   
    public int deleteGamecenterAd(int id) {
	int flag = gamecenterAdMapper.deleteGamecenterAdByPrimaryKey(id);
	return flag;
    }

    /**
     * 更新gamecenterAd
     */
    public int updateGamecenterAd(GamecenterAdModifyDTO record) {
	int flag = gamecenterAdMapper.updateGamecenterAd(record);

	return flag;
    }

    /**
     * 获取gamecenterAd总数目
     */
   
    public int getGamecenterAdListTotalCountByCriteria(
	    GamecenterAdSearchCriteriaDTO criteria) {

	return gamecenterAdMapper.getGamecenterAdListTotalCountByCriteria(criteria);
    }

    /**
     * 验证gamecenterAd是否存在
     */
   
    public int checkGamecenterAdDuplication(String name, int id) {

	return gamecenterAdMapper.checkIfGamecenterAdExist(name, id);
    }

   
    
    public int updateShowIndex(GamecenterAdModifyDTO gamecenterAd) {
	// TODO Auto-generated method stub
	int originalIndex=gamecenterAd.getOriginalIndex();
	int showIndex = gamecenterAd.getShowIndex();
	Boolean move;
	if(originalIndex>showIndex){
	    move=true;
	}
	else if(originalIndex<showIndex){
	    move=false;
	}
	else{
	    return 0;
	}
	int updateNum=gamecenterAdMapper.updateAllShowIndex(move,originalIndex,showIndex);
	gamecenterAdMapper.updateShowIndex(gamecenterAd);
	  
	return updateNum+1;
   }
  
}
